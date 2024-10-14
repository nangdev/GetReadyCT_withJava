package study.problem;

import java.util.Scanner;

public class P2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int cnt = 1;
		int ran = 2;

		if (n == 1) {
			System.out.println(1);
		}

		else {
			while (ran <= n) {
				ran = ran + (6 * cnt);
				cnt++;
			}
			System.out.println(cnt);
		}

	}
}
