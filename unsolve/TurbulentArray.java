package OJSolution.unsolve;

public class TurbulentArray {
    public void test() {
        //[4,8,12,16]
        // 9,9
        // 9,9,9 [0,1,1,0,1,0,1,1,0,0]
        int[] ans = new int[]{9, 9};
        System.out.println(maxTurbulenceSize(ans));
        ans = new int[]{9, 9, 9};
        System.out.println(maxTurbulenceSize(ans));
        ans = new int[]{4, 8, 12, 16};
        System.out.println(maxTurbulenceSize(ans));
        ans = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(maxTurbulenceSize(ans));
        ans = new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(maxTurbulenceSize(ans));
    }

    private int maxTurbulenceSize(int[] A) {
        int ans = 1;
        int anchor = 0;
        if (A.length == 1) {
            return 1;
        }
        int c = Integer.compare(A[1], A[0]);
        for (int i = 1; i < A.length; i++) {
            if ((c * Integer.compare(A[i - 1], A[i])) == -1) {
                ans = Integer.max(ans, i - anchor + 1);
            } else {
                anchor = i - 1;
            }
            c = Integer.compare(A[i - 1], A[i]);
        }
        return ans;
    }
}
