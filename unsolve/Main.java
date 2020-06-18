package OJSolution.unsolve;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class Main {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            list.clear();
            String s = sc.nextLine();
            String[] ss = s.split(",");
            Arrays.sort(ss);
            String so = Arrays.deepToString(ss).replace("[", "").replace(", ", ",").replace("]", "");
            System.out.println(so);
        }
    }
}