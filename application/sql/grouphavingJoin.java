package OJSolution.application.sql;

import java.util.*;

public class grouphavingJoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        int n = sc.nextInt();
        Map<String, List<String>> userTable = new HashMap<>();
        String user, table;
        for (int i = 0; i < n; i++) {
            table = sc.next();
            user = sc.next();
            if (userTable.containsKey(user)) {
                List<String> tables = userTable.get(user);
                tables.add(table);
                userTable.put(user, tables);
            } else {
                List<String> tables = new LinkedList<>();
                tables.add(table);
                userTable.put(user, tables);
            }
        }
        Map<String, Integer> tableNum = new HashMap<>();
        for (List<String> tables : userTable.values()) {
            for (int i = 0; i < tables.size() - 1; i++) {
                for (int j = i + 1; j < tables.size(); j++) {
                    String t1 = String.format("%10s", tables.get(i));
                    String t2 = String.format("%10s", tables.get(j));
                    Integer num = tableNum.getOrDefault(t1 + t2, 0);
                    tableNum.put(t1 + t2, num + 1);
                    tableNum.put(t2 + t1, num + 1);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : tableNum.entrySet()) {
            if (entry.getValue() > 2) {
                ans.add(entry.getKey() + entry.getValue());
            }
        }
        Collections.sort(ans);
        for (String s : ans) {
            String s1 = s.substring(0, 10).trim();
            String s2 = s.substring(10, 20).trim();
            String s3 = s.substring(20);
            System.out.println(s1 + " " + s2 + " " + s3);
        }
    }
}
