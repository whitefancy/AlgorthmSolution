package OJSolution.application.bit_bitset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GrayCode {
    public static void main(String[] args) {
        List<Integer> ans = new GrayCode().grayCode(4);
        for (Integer in : ans) {
            System.out.print(in + " ");
        }
    }

    /**
     * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     * <p>
     * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/gray-code
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * bwftag  格雷编码 镜面反射 递推 状态ok
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n < 1) {
            ans.add(0);
            return ans;
        }
        List<String> list = new LinkedList<>();
        list.add("0");
        list.add("1");
        for (int i = 1; i < n; i++) {
            list = glayGenerator(list);
        }
        for (String s : list) {
            ans.add(Integer.valueOf(s, 2));
        }
        return ans;
    }

    private List<String> glayGenerator(List<String> list) {
        List<String> list1 = new ArrayList<>(list.size() * 2);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i) + "0";
            list1.add(s);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i) + "1";
            list1.add(s);
        }
        return list1;
    }
}