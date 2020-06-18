package OJSolution.application.maths;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScorePercent {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] scores;
        String key;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        scores = new int[n];
        int[] stu = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            stu[i] = scores[i];
        }
        Arrays.sort(scores);
        int max = scores[0];
        int num = 0;
        for (int i = 0; i < scores.length; i++) {
            if (max < scores[i]) {
                map.put(max, num);
                max = scores[i];
            }
            num++;
        }
        map.put(scores[n - 1], n);
        int h = sc.nextInt();
        for (int i = 0; i < h; i++) {
            int s = sc.nextInt();
            System.out.printf("%.6f\n", 100.0 * (map.get(stu[s - 1]) - 1) / (1.0 * n));
        }
    }
}
