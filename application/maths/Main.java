package OJSolution.application.maths;

public class Main {
    public static void main(String args[]) {
        //Perimeter pe = new Perimeter();
        Rolls so = new Rolls();
        System.out.println(so.numRollsToTarget(1, 6, 3));//1
        System.out.println(so.numRollsToTarget(2, 6, 7));//6
        System.out.println(so.numRollsToTarget(2, 5, 10));//1
        System.out.println(so.numRollsToTarget(1, 2, 3));
        System.out.println(so.numRollsToTarget(30, 30, 500));
        // so.performance();
    }
}