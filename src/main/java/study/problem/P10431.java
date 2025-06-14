package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10431 {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int p = Integer.parseInt(br.readLine());

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int ans = 0;
			arr = new int[20];

			for (int j = 0; j < 20; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < 20; j++) {
				for (int k = 0; k < j; k++) {
					if (arr[k] > arr[j]) {
						while (j != k) {
							swap(j, j - 1);
							j--;
							ans++;
						}
					}
				}
			}

			sb.append(t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void swap(int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
}
