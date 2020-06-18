package OJSolution.application.string;

import java.util.*;

/**
 * 去掉%22 和ip地址信息，得到用户所在的公司关键词
 * *bwftag  字符串解析 套接字 状态ok
 */
public class CiscoUrl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(CiscoUrl.getURLName(s));
            Map<String, String> map = new HashMap<>();
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    }

    private static String getURLName(String s) {
        s = s.trim().replace("\"", "").replace("'", "");
        String s1 = s.split("<sip:")[0];
        String ans;
        if (s1.length() < 3) {
            return s1;
        }
        if ("%22".equals(s1.substring(0, 3))) {
            ans = s1.substring(3, s1.length() - 3);
        } else {
            ans = s1;
        }
        return ans;
    }
}
