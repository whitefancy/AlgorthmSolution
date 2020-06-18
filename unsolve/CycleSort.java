package OJSolution.unsolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Welcome to vivo !
 */
public class CycleSort {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = CycleSort.parseInts(inputStr.split(" "));
        String output = CycleSort.solution(input);
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
     * 包含n个人的循环队列中，每次第k个人出列，问新的队列是什么
     *
     * @param input
     * @return
     */
    private static String solution(int[] input) {

        // TODO Write your code here

        int n = input[0];
        int k = input[1];
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = (i + 1);
        }
        List<Integer> ans = new LinkedList<>();
        int i = k - 1;
        while (ans.size() != n) {
            int p = A[i];
            ans.add(p);
            A[i] = -1;
            int temp = 0;
            i++;
            while (temp < k - 1) {
                if (i < n - 1 && A[i] == -1) {
                    i++;
                } else {
                    i++;
                    temp++;
                }
                if (i > n - 1) {
                    i = i - n;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < ans.size(); j++) {
            sb.append(ans.get(j));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}