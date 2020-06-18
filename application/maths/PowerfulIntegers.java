package OJSolution.application.maths;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.lang.Math.pow;


public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        if (bound < 2) {
            return list;
        }
        if (x == 1 && y == 1) {
            list.add(2);
            return list;
        } else if (x == 1) {
            for (int j = 0; 1 + pow(y, j) <= bound; j++) {
                int num = (int) (1 + pow(y, j));
                set.add(num);
            }
        } else if (y == 1) {
            for (int j = 0; 1 + pow(x, j) <= bound; j++) {
                int num = (int) (1 + pow(x, j));
                set.add(num);
            }
        } else {
            for (int i = 0; pow(x, i) < bound; i++) {
                for (int j = 0; pow(x, i) + pow(y, j) <= bound; j++) {
                    int num = (int) (pow(x, i) + pow(y, j));
                    set.add(num);
                }
            }
        }
        list.addAll(set);
        return list;
    }
}
