package Algorithm.basicKnowledge.dataStructure.String;

import java.util.*;

/**
 * Input = ["ant", "tan", "an", "at", "anta"]
 * Output = [
 * ["ant", "tan"],
 * ["an"],
 * ["at"],
 * ["anta"]
 * ]
 */
public class StringHash {
    List<List<String>> group(String[] strings) {
        if (strings == null) {
            return new ArrayList();
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            int hashcode = getHash(strings[i]);
            if (map.containsKey(hashcode)) {
                List<String> list = map.get(hashcode);
                list.add(strings[i]);
            } else {
                List<String> list = new LinkedList<>();
                list.add(strings[i]);
                map.put(hashcode, list);
            }
        }
        return (List<List<String>>) map.values();
    }

    int getHash(String s) {
        int[] cs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i) - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int k = cs[i];
            char c = (char) (i + 'a');
            while (k-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString().hashCode();
    }

}

