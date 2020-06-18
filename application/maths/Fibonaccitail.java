package OJSolution.application.maths;

import java.util.Scanner;

class Fibonaccitail {
    //    题目描述
//    NowCoder号称自己已经记住了1-100000之间所有的斐波那契数。
//    为了考验他，我们随便出一个数n，让他说出第n个斐波那契数。当然，斐波那契数会很大。因此，如果第n个斐波那契数不到6位，则说出该数；否则只说出最后6位。
//
//    输入描述:
//    输入有多组数据。
//    每组数据一行，包含一个整数n (1≤n≤100000)。
//
//
//    输出描述:
//    对应每一组输入，输出第n个斐波那契数的最后6位。
//    对于这样类似的题目,最好的方式是进行预处理,把要计算的数值进行第一次计算的时候存储下来,然后剩下的测试用例只进行查找即可，因为查找比计算更加高效，再加上一次运算总比次次运算要快。不要担心第一次计算那么大数值时候回超时，因为这个数量级的运算还是很快的。
    private int[] nums = new int[100001];

    Fibonaccitail() {
        nums[1] = 1;
        nums[2] = 2;
        int a = 1;
        int b = 2;
        int sum;
        for (int i = 2; i < 100000; ) {
            sum = (a + b) % 1000000;
            // time out
//            sum=a+b;
//            if(sum>=1000000)
//            {
//                sum-=1000000;
//            }
            //time out too;
            i++;
            nums[i] = sum;
            a = b;
            b = sum;
        }
    }

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //注意：给定 n 是一个正整数。
    private int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int climbStairs1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private int checkFn(int n) {
        return nums[n];
    }

    public void test() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(checkFn(n));
        }
    }
}