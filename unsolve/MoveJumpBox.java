package OJSolution.unsolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Welcome to vivo !
 */
public class MoveJumpBox {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        if (inputStr.trim().length() == 0) {
            System.out.println(-1);
            return;
        }
        int input[] = MoveJumpBox.parseInts(inputStr.split(" "));
        int output = MoveJumpBox.solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    /**
     * 每个盒子上是最大的移动步数，问最少移动几次到最后一个盒子上。
     * 通过70%的case
     *
     * @param input
     * @return
     */
    private static int solution(int[] input) {

        // TODO Write your code here
        if (input.length == 0) {
            return -1;
        }
        if (input.length == 1) {
            return 0;
        }
        int src = 0;
        int dst = input.length - 1;
        int count = 0;
        return MoveJumpBox.minStepsTo(input, src, dst, count);
    }

    private static int minStepsTo(int[] input, int src, int dst, int count) {
        if (src >= dst) {
            return 1;
        }
        int n = input[src];
        int minCount = Integer.MAX_VALUE;
        boolean valid = false;
        if (n == 0) {
            return -1;
        }
        for (int i = n; i > 0; i--) {
            int temp = MoveJumpBox.minStepsTo(input, i + src, dst, count + 1);
            if (temp > -1 && temp < minCount) {
                valid = true;
                minCount = temp;
            }
        }
        if (valid) {
            return count + minCount;
        } else {
            return -1;
        }
    }
}