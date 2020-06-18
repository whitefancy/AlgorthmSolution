package OJSolution.application.maths;

public class RationalEqual {
    public void test() {
        // "0.9(9)","1."
        //"0.(52)","0.5(25)"
        //"1","1.0"  "0.","0"   "1414.1414(14)" ,"1414.14(1414)"
        System.out.println(isRationalEqual("1414.1414(14)", "1414.14(1414)"));
    }

    private boolean isRationalEqual(String S, String T) {
        long[] s = ToFraction(S);
        long[] t = ToFraction(T);
        if ((s[0] == t[0]) && (s[0] == 0 || s[1] == t[1])) {
            return true;
        } else {
            return false;
        }
    }

    private long[] ToFraction(String s) {
        long[] nums = new long[5];
        String z = "0", x = "0", h = "0";
        int b = 1, d = 1;
        if (s.indexOf(".") == -1) {
            z = s;
        } else if (s.indexOf("(") == -1) {
            z = s.substring(0, s.indexOf("."));
            nums[0] = Integer.valueOf(z);
            x = s.substring(s.indexOf(".") + 1);

        } else if (s.indexOf("(") != -1) {

            z = s.substring(0, s.indexOf("."));
            x = s.substring(s.indexOf(".") + 1, s.indexOf("("));
            h = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
        }
        int len = x.length();
        b = 1;
        while (len-- > 0) {
            b *= 10;
        }
        len = h.length();
        while (len-- > 0) {
            d *= 10;
        }
        nums[0] = Integer.valueOf(z);
        if (x.length() > 0) {
            nums[1] = Integer.valueOf(x);
        }
        nums[2] = b;
        nums[3] = Integer.valueOf(h);
        nums[4] = (d - 1) * b;
        long[] xs = add(nums[1], nums[2], nums[3], nums[4]);

        return add(nums[0], 1, xs[0], xs[1]);
    }

    public long[] add(long a, long b, long c, long d) {
        // a/b +c/d
        long[] ans = new long[2];
        long m = a * d + b * c;
        long n = b * d;
        long k = MaximumCommonDivisor(m, n);
        ans[0] = m / k;
        ans[1] = n / k;
        return ans;
    }

    private long MaximumCommonDivisor(long a, long b) {
        //辗转相除法
        if (a == 0 || b == 0) {
            return 1;
        }
        long m = a > b ? a : b;
        long n = a > b ? b : a;
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
