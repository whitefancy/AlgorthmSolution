package OJSolution.application.heap_priorityqueue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * <p>
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 */
public class Twitter {
    private Map<Integer, List<Tweet>> usersAndFeeds = new HashMap<>();
    private Map<Integer, List<Integer>> userAndFollows = new HashMap<>();
    private int time = 0;

    /**
     * Initialize your data structure here.
     */
    private Twitter() {

    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        twitter.getNewsFeed(1);
        twitter.follow(2, 1);
        twitter.getNewsFeed(2);
        twitter.unfollow(2, 1);
        twitter.getNewsFeed(2);
        twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
    }

    /**
     * Compose a new tweet.
     */
    private void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        List<Tweet> list = usersAndFeeds.getOrDefault(userId,
                new LinkedList<>());
        list.add(tweet);
        usersAndFeeds.putIfAbsent(userId, list);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    private List<Integer> getNewsFeed(int userId) {
        List<Integer> followees = userAndFollows.getOrDefault(userId, new LinkedList<>());
        if (!followees.contains(userId)) {
            followees.add(userId);
        }
        PriorityQueue<Tweet> queue = new PriorityQueue<>((o1, o2) -> (o2.time - o1.time));
        for (int i = 0; i < followees.size(); i++) {
            if (usersAndFeeds.get(followees.get(i)) != null) {
                queue.addAll(usersAndFeeds.get(followees.get(i)));
            }
        }
        List<Tweet> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            if (!queue.isEmpty()) {
                list.add(queue.poll());
            }
        }
        queue.addAll(list);
        return list.stream().map(Tweet::getTweetId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    private void follow(int followerId, int followeeId) {
        List<Integer> followees = userAndFollows.getOrDefault(followerId, new LinkedList<>());
        if (!followees.contains(followeeId)) {
            followees.add(followeeId);
        }
        userAndFollows.putIfAbsent(followerId, followees);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    private void unfollow(int followerId, int followeeId) {
        List<Integer> followees = userAndFollows.getOrDefault(followerId, new LinkedList<>());
        Iterator<Integer> it = followees.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (id == followeeId) {
                it.remove();
                break;
            }
        }
    }
}

class Tweet {
    public int time;
    private int tweetId;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }

    int getTweetId() {
        return tweetId;
    }
}
