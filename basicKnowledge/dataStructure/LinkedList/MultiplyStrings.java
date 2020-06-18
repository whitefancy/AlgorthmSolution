package Algorithm.basicKnowledge.dataStructure.LinkedList;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 执行结果：
 * 通过
 */
public class MultiplyStrings {
    /**
     * 先保存临时结果，最后统一进位
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] ans = new int[n1 + n2];
        for (int i = n1 - 1; i > -1; i--) {
            for (int j = n2 - 1; j > -1; j--) {
                ans[i + j + 1] = ans[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int temp = 0;
        for (int i = ans.length - 1; i > -1; i--) {
            int p = ans[i] + temp;
            temp = p / 10;
            ans[i] = p % 10;
        }

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (ans[k] == 0) {
            k++;
        }
        while (k < ans.length) {
            sb.append(ans[k]);
            k++;
        }
        return sb.toString();
    }
}
