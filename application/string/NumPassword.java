package OJSolution.application.string;

import java.util.*;

public class NumPassword {
    // one !two !three !four !five !six !seven !eight  !nine zero
    private void unlock(String password) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < password.length(); i++) {
            String ch = ("" + password.charAt(i)).toLowerCase();
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int len = 0;
        List<Integer> list = new ArrayList<>();
        while (len < password.length()) {
            while (map.containsKey("g") && map.get("t") > 0 &&
                    map.get("h") > 0 &&
                    map.get("g") > 0 &&
                    map.get("i") > 0 &&
                    map.get("e") > 0) {
                list.add(8);
                map.put("t", map.get("t") - 1);
                map.put("h", map.get("h") - 1);
                map.put("g", map.get("g") - 1);
                map.put("i", map.get("i") - 1);
                map.put("e", map.get("e") - 1);
                len += 5;
            }
            while (map.containsKey("h") && map.get("t") > 0 &&
                    map.get("h") > 0 &&
                    map.get("r") > 0 &&
                    map.get("e") > 1) {
                list.add(3);
                map.put("t", map.get("t") - 1);
                map.put("h", map.get("h") - 1);
                map.put("r", map.get("r") - 1);
                map.put("e", map.get("e") - 2);
                len += 5;
            }
            while (map.containsKey("x") && map.get("s") > 0 &&
                    map.get("i") > 0 &&
                    map.get("x") > 0) {
                list.add(6);
                map.put("s", map.get("s") - 1);
                map.put("i", map.get("i") - 1);
                map.put("x", map.get("x") - 1);
                len += 3;
            }
            while (map.containsKey("s") && map.get("s") > 0 &&
                    map.get("v") > 0 &&
                    map.get("n") > 0 &&
                    map.get("e") > 1) {
                list.add(7);
                map.put("s", map.get("s") - 1);
                map.put("v", map.get("v") - 1);
                map.put("n", map.get("n") - 1);
                map.put("e", map.get("e") - 2);
                len += 5;
            }
            while (map.containsKey("w") && map.get("t") > 0 &&
                    map.get("w") > 0 &&
                    map.get("o") > 0) {
                list.add(2);
                map.put("t", map.get("t") - 1);
                map.put("w", map.get("w") - 1);
                map.put("o", map.get("o") - 1);
                len += 3;
            }
            while (map.containsKey("v") && map.get("f") > 0 &&
                    map.get("i") > 0 &&
                    map.get("v") > 0 &&
                    map.get("e") > 0) {
                list.add(5);
                map.put("f", map.get("f") - 1);
                map.put("i", map.get("i") - 1);
                map.put("v", map.get("v") - 1);
                map.put("e", map.get("e") - 1);
                len += 4;
            }
            while (map.containsKey("f") && map.get("f") > 0 &&
                    map.get("o") > 0 &&
                    map.get("u") > 0 &&
                    map.get("r") > 0) {
                list.add(4);
                map.put("f", map.get("f") - 1);
                map.put("o", map.get("o") - 1);
                map.put("u", map.get("u") - 1);
                map.put("r", map.get("r") - 1);
                len += 4;
            }
            while (map.containsKey("i") && map.get("i") > 0 &&
                    map.get("e") > 0 &&
                    map.get("n") > 1) {
                list.add(9);
                map.put("i", map.get("i") - 1);
                map.put("e", map.get("e") - 1);
                map.put("n", map.get("n") - 2);
                len += 4;
            }
            while (map.containsKey("z") && map.get("z") > 0 &&
                    map.get("o") > 0 &&
                    map.get("e") > 0 &&
                    map.get("r") > 0) {
                list.add(0);
                map.put("z", map.get("z") - 1);
                map.put("o", map.get("o") - 1);
                map.put("e", map.get("e") - 1);
                map.put("r", map.get("r") - 1);
                len += 4;
            }
            while (map.containsKey("n") && map.get("n") > 0 &&
                    map.get("e") > 0 &&
                    map.get("o") > 0) {
                list.add(1);
                map.put("n", map.get("n") - 1);
                map.put("e", map.get("e") - 1);
                map.put("o", map.get("o") - 1);
                len += 3;
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i));
        }
        System.out.println(list.get(list.size() - 1));

    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            unlock(s);
        }
    }
}
