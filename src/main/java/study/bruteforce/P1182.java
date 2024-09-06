package study.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1182 {
	static int n, s, answer;
	static int[] arr, result;
	static boolean[] selec;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];
		result = new int[n];
		selec = new boolean[n];
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		subset(0);

		System.out.println(answer);
	}

	static void subset(int cnt) {
		if (cnt == n) {

			int chk = 0;
			for (int i = 0; i < n; i++) {
				if (!selec[i]) {
					chk++;
				}
			}

			if (chk == n) {
				return;
			}

			int temp = Arrays.stream(result).sum();
			if (temp == s) {
				answer++;
			}
			return;
		}

		selec[cnt] = true;
		result[cnt] = arr[cnt];
		subset(cnt + 1);

		selec[cnt] = false;
		result[cnt] = 0;
		subset(cnt + 1);
	}
}
