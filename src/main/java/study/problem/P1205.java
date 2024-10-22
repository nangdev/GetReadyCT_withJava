package study.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int newscore = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		if (n == 0) {
			System.out.println(1);
			return;
		}

		Integer[] arr = new Integer[n + 1];
		arr[0] = newscore;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		if (n == p && arr[n] == newscore) {
			System.out.println(-1);
			return;
		}

		int cnt = 1;
		for (int i = 0; i < n + 1; i++) {
			if (arr[i] == newscore) {
				for (int j = 0; j < i; j++) {
					cnt++;
				}
				break;
			}
		}

		System.out.println(cnt);
	}
}
