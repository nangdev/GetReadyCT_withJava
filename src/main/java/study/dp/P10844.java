package study.dp;

import java.util.Scanner;

public class P10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] dp = new int[n + 1][10];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i < n + 1; i++) {

			for (int j = 1; j < 10; j++) {
				// dp[i][j] =
			}
		}

	}

}
