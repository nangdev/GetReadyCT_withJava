package solvedac.class2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2609 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\CTReady_withJava\\src\\main\\java\\solvedac\\class1\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        System.out.println(gcd(N,M));
        System.out.println(lcm(N,M));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
