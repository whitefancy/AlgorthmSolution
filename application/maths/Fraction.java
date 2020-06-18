package OJSolution.application.maths;

public class Fraction {
    public void test() {
        int[] ans = add(4, 3, 2, 6);
        System.out.println(ans[0] + "/" + ans[1]);
    }

    public int[] add(int a, int b, int c, int d) {
        // a/b +c/d
        int[] ans = new int[2];
        int m = a * d + b * c;
        int n = b * d;
        int k = MaximumCommonDivisor(m, n);
        ans[0] = m / k;
        ans[1] = n / k;
        return ans;
    }

    public int[] multi(int a, int b, int c, int d) {
        // a/b *c/d
        int[] ans = new int[2];
        int m = a * c;
        int n = b * d;
        int k = MaximumCommonDivisor(m, n);
        ans[0] = m / k;
        ans[1] = n / k;
        return ans;
    }

    public int[] divide(int a, int b, int c, int d) {
        // a/b / (c/d)
        int[] ans = new int[2];
        int m = a * d;
        int n = b * c;
        int k = MaximumCommonDivisor(m, n);
        ans[0] = m / k;
        ans[1] = n / k;
        return ans;
    }

    private int MaximumCommonDivisor(int a, int b) {
        //辗转相除法
        if (a == 0 || b == 0) {
            return 1;
        }
        int m = a > b ? a : b;
        int n = a > b ? b : a;
        while (true) {
            if ((m = m % n) == 0) {
                return n;
            }
            if ((n = n % m) == 0) {
                return m;
            }
        }
    }
}
