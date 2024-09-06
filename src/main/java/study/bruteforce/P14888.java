package study.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
	static int n;
	static long resMin = Integer.MAX_VALUE, resMax = Integer.MIN_VALUE;
	static int[] arr;
	static int[] buhonum = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			buhonum[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, arr[0]);

		System.out.println(resMax);
		System.out.println(resMin);

	}

	static void dfs(int cnt, int cur) {
		if (cnt == n) {
			resMin = Math.min(resMin, cur);
			resMax = Math.max(resMax, cur);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (buhonum[i] != 0) {
				if (i == 0) {
					buhonum[i]--;
					dfs(cnt + 1, cur + arr[cnt]);
					buhonum[i]++;
				} else if (i == 1) {
					buhonum[i]--;
					dfs(cnt + 1, cur - arr[cnt]);
					buhonum[i]++;
				} else if (i == 2) {
					buhonum[i]--;
					dfs(cnt + 1, cur * arr[cnt]);
					buhonum[i]++;
				} else {
					buhonum[i]--;
//					int temp = 0;
//					if (cur < 0) {
//						temp = ((cur * -1) / arr[cnt]) * -1;
//					}
					dfs(cnt + 1, cur / arr[cnt]);
					buhonum[i]++;
				}

			}
		}
	}

}
