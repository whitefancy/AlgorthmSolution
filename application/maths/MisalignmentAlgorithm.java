package OJSolution.application.maths;

import java.util.Scanner;

public class MisalignmentAlgorithm {
    //    NowCoder每天要给很多人发邮件。有一天他发现发错了邮件，把发给A的邮件发给了B，把发给B的邮件发给了A。于是他就思考，要给n个人发邮件，在每个人仅收到1封邮件的情况下，有多少种情况是所有人都收到了错误的邮件？
//    即没有人收到属于自己的邮件。
    private long misalignment(long n) {
        long a = 0, b = 1;
        long dn = 1;
        for (int i = 2; i < n; i++) {
            dn = i * (a + b);
            a = b;
            b = dn;
        }
        return dn;
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            System.out.println(misalignment(n));
        }
    }
}
