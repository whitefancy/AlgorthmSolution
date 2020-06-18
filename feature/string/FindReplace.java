package OJSolution.feature.string;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class FindReplace {
    //    输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//    输出：["mee","aqq"] ["abc","cba","xyx","yxx""yyx"],
//"abc"
//    解释：
//            "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//            "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//    因为 a 和 b 映射到同一个字母。
    public void test() {
        String[] words = new String[]{"abc", "cba", "xyx", "yxx", "yyx"};
        String s = findAndReplacePattern(words, "abc").toString();
        System.out.println(s);
    }

    private List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        List<Integer> pat = word2Index(pattern);
        for (int i = 0; i < words.length; i++) {
            List<Integer> word = word2Index(words[i]);
            if (word.equals(pat)) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private List<Integer> word2Index(String cur) {
        int index = 0;
        Map<Character, Integer> map = new Hashtable<>();
        List<Integer> word = new ArrayList<>();
        for (int j = 0; j < cur.length(); j++) {
            Integer value = map.get(cur.charAt(j));
            if (value == null) {
                map.put(cur.charAt(j), index++);
            }
            word.add(map.get(cur.charAt(j)));
        }
        return word;
    }
}
