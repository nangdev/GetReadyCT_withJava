package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17069 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		int[][][] dp = new int[3][n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (map[n - 1][n - 1] == 1) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (map[0][i] != 1)
				dp[0][i][0] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 2; j < n; j++) {
				if (map[i][j] != 1) {
					dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];
					dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];
					dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];

				} else {
					dp[0][i][j] = 0;
					dp[1][i][j] = 0;
					dp[2][i][j] = 0;
				}
			}

		}

		int result = 0;
		for (int i = 0; i < 3; i++) {
			result += dp[i][n - 1][n - 1];
		}

		System.out.println(result);
	}

}
