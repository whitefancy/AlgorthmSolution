package OJSolution.application.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 设计⼀个数据结构WordFilter，⽤来存储含有百万量级单词的词库，并尽可能⾼效
 * 的判断给定⼀个字符串中是否含有词库中的某个单词。
 * 解法 ConcurrentHashMap
 */
public class MacthInDict {
    public static void main(String[] args) {
        WordFilter1 wordFilter = new WordFilter1();
        for (int i = 0; i < 2000000; i++) {
            wordFilter.addWord("WordFilter玩游戏" + i);
        }
        System.out.println(wordFilter.isMatch("WordFilter玩游戏54523"));//true
        System.out.println(wordFilter.isMatch("WordFilte1r玩游戏54523"));//false
    }
}

//该数据结构基本定义如下
class WordFilter1 {
    //考虑到含有百万量级单词的词库，插入可能是并发操作，所以使用ConcurrentHashMap
    ConcurrentHashMap<String, Boolean> dict = new ConcurrentHashMap<>();

    //添加⼀个词库中的单词word到你的⾃定义存储结构中
    public void addWord(String word) {
        dict.putIfAbsent(word, Boolean.TRUE);
    }

    //判断给你的字符串input中是否含有词库中的某个单词，
//只要含有任意⼀个就返回true，否则返回false
    public boolean isMatch(String input) {
        // 去除标点符号，转换成单词
        String[] strings = input.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", " ")
                .split(" ");
        //输入中的单词去重
        List<String> lists = Arrays.stream(strings).distinct().collect(Collectors.toList());
        for (int i = 0; i < lists.size(); i++) {
            if (dict.getOrDefault(lists.get(i), false)) {
                return true;
            }
        }
        return false;
    }
}