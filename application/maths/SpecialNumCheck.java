package OJSolution.application.maths;

public class SpecialNumCheck {
    public void test() {
        //   System.out.println(titleToNumber("ZY"));
        System.out.println(isUgly(1));
        System.out.println(isUgly(14));
        System.out.println(isUgly(20));
        System.out.println(isUgly(3));
    }

    //    编写一个程序判断给定的数是否为丑数。
//    丑数就是只包含质因数 2, 3, 5 的正整数。
    private boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while ((num % 2 == 0)) {
            num /= 2;
        }
        while ((num % 3 == 0)) {
            num /= 3;
        }
        while ((num % 5 == 0)) {
            num /= 5;
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

}
