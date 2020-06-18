package OJSolution.unsolve;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum Action {
    login, task1, task2, task3, logout
}

/**
 * 日志分析 用户在特定应用的停留时间
 * *bwftag  日志 字符串解析  状态失败
 */
public class UserActions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        int n = sc.nextInt();
        if (n < 2) {
            return;
        }
        Map<String, User> users = new HashMap<>();
        sc.nextLine();
        String log = sc.nextLine();
        String action;
        LocalDateTime time;
        String id;
        String temp;
        for (int i = 0; i < n - 1; i++) {
            String next = sc.nextLine();
            temp = log.substring(1, 20);
            time = LocalDateTime.parse(log.substring(1, 20).replace(' ', 'T'));
            LocalDateTime endtime = LocalDateTime.parse(next.substring(1, 20).replace(' ', 'T'));
            log = log.substring(22);
            action = log.split("]")[0];
            if (log.indexOf("role_id") == -1) {
                log = next;
                continue;
            }
            id = log.split(":")[1];
            id = id.substring(1, id.length() - 2);
            if (!action.equals("login") &&
                    !action.equals("logout") &&
                    !action.equals("task1") &&
                    !action.equals("task2") &&
                    !action.equals("task3")) {
                log = next;
                continue;
            }
            if (Action.valueOf(action) == Action.login) {
                User user = users.getOrDefault(id, new User());
                if (user.login == null || user.logout != null) {
                    user.login = time;
                    user.logout = null;
                    users.put(id, user);
                }
            }
            if (Action.valueOf(action) == Action.logout) {
                User user = users.getOrDefault(id, new User());
                if (user.login != null && user.logout == null) {
                    user.logout = time;
                    users.put(id, user);
                }
            }
            if (Action.valueOf(action) == Action.task1) {
                User user = users.getOrDefault(id, new User());
                if (user.login != null && user.logout == null) {
                    user.task1 = Duration.between(time, endtime);
                    users.put(id, user);
                }
            }
            if (Action.valueOf(action) == Action.task2) {
                User user = users.getOrDefault(id, new User());
                if (user.login != null && user.logout == null) {
                    user.task2 = Duration.between(time, endtime);
                    users.put(id, user);
                }
            }
            if (Action.valueOf(action) == Action.task3) {
                User user = users.getOrDefault(id, new User());
                if (user.login != null && user.logout == null) {
                    user.task3 = Duration.between(time, endtime);
                    users.put(id, user);
                }
            }
            log = next;
        }

        time = LocalDateTime.parse(log.substring(1, 20).replace(' ', 'T'));
        log = log.substring(22);
        action = log.split("]")[0];
        if (log.indexOf("role_id") != -1 &&
                Action.valueOf(action) == Action.logout) {
            id = log.split(":")[1];
            id = id.substring(1, id.length() - 2);
            User user = users.getOrDefault(id, new User());
            if (user.login != null && user.logout == null) {
                user.logout = time;
                users.put(id, user);
            }
        }
        Summary[] ans = new Summary[3];
        for (int i = 0; i < 3; i++) {
            ans[i] = new Summary();
        }
        for (User user : users.values()) {
            if (user.login != null && user.logout != null) {
                if (user.task1 != null) {
                    ans[0].duration = ans[0].duration.plus(user.task1);
                    ans[0].users++;
                }
                if (user.task2 != null) {
                    ans[1].duration = ans[1].duration.plus(user.task2);
                    ans[1].users++;
                }
                if (user.task3 != null) {
                    ans[2].duration = ans[2].duration.plus(user.task3);
                    ans[2].users++;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (ans[i].duration != Duration.ZERO) {
                System.out.println("task" + (i + 1) + "," + ans[i].users + "," + ans[i].duration.getSeconds());
            }
        }
    }
}

class Summary {
    Duration duration;
    Integer users;

    Summary() {
        duration = Duration.ZERO;
        users = 0;
    }
}

class User {
    public String id;
    LocalDateTime login;
    LocalDateTime logout;
    Duration task1;
    Duration task2;
    Duration task3;
}