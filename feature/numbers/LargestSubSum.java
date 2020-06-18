package OJSolution.feature.numbers;

import java.util.Scanner;

/**
 * 有正有负的数组
 * 求其和最大的连续子串
 * 输出它的和
 * *bwftag  一般特性 数组连续子列 状态ok
 */
public class LargestSubSum {
    private static int LargestSum(int[] arr) {
        int max = arr[0];
        int cur = max;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max && arr[i] > (arr[i] + cur)) {
                max = arr[i];
                cur = max;
            } else if (arr[i] <= max && (arr[i] + cur) <= max) {
                cur += arr[i];
            } else {
                max = cur + arr[i];
                cur = max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(LargestSubSum.LargestSum(arr));
        }
    }
}
