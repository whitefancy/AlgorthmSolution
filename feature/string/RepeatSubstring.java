package OJSolution.feature.string;

import java.util.HashSet;
import java.util.Set;

public class RepeatSubstring {
    private Set<Integer> set = new HashSet<>();

    public boolean repeatedSubstringPattern(String s) {
        set.add(1);
        if (s.length() < 2) {
            return false;
        }
        int flag;
        for (int i = 2; i <= s.length(); i++) {
            if (s.length() % i == 0) {
                flag = 1;
                int size = s.length() / i;
                String s1 = s.substring(0, size);
                for (int j = 1; j < i; j++) {
                    String s2 = s.substring(size * j, size * j + size);
                    if (!s1.equals(s2)) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
