package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

//buwenfeng
/*
/0 N
-1+2 Y
1 Y
1= Y
/3 Y
*4 N
2-/+3 Y
2=3 N
2=-3 N
*/
//面向对象 Calculator 计算器 +-*/ = 实时 整数 List<Integer> 合法
public class OOCalcutor {
    int ans = 0;
    int temp = 0;
    char op = '+';

    void cal(String s)//s 数字 或符号
    {
        if (Character.isDigit(s.charAt(0))) {
            temp = Integer.parseInt(s);
            return;
        }
        if (op == '=') {
            equal();
        }
        switch (op) {
            case '+':
                add(temp);
                break;//等价于 cal.add(temp)
            case '-':
                minus(temp);
                break;
            case '*':
                multiply(temp);
                break;
            case '/':
                //temp==0 exception
                divide(temp);
                break;
        }
        op = s.charAt(0);
        return;
    }

    int equal() {
        print(ans);
        //ans=0;
        return ans;
    }

    int add(int b) {
        ans += b;
        print(ans);
        return ans;
    }

    int divide(int b) {
        ans /= b;
        print(ans);
        return ans;
    }

    int minus(int b) {
        ans -= b;
        print(ans);
        return ans;
    }

    int multiply(int b) {
        ans *= b;
        print(ans);
        return ans;
    }

    void print(int a) {
        System.out.println(a);
    }
}