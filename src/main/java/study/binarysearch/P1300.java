package study.binarysearch;

import java.util.Scanner;

public class P1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long min = 1;
        long max = k;

        while (min < max) {
            long mid = (min + max) / 2;

            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }

            if (cnt < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min);
    }
}
