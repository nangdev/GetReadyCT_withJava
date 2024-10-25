package study.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int stunum = Integer.parseInt(br.readLine());

		int[][] student = new int[stunum][2];

		for (int i = 0; i < stunum; i++) {
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < stunum; i++) {

			if (student[i][0] == 1) {
				for (int j = 1; j <= n; j++) {
					int num = student[i][1] * j - 1;
					if (num < n) {
						if (arr[num] == 1) {
							arr[num] = 0;
						} else {
							arr[num] = 1;
						}
					} else {
						continue;
					}
				}
			}

			else {
				int left = -1;
				int right = 1;
				int num = student[i][1] - 1;

				if (arr[num] == 1) {
					arr[num] = 0;
				} else {
					arr[num] = 1;
				}

				while (true) {
					int nextleft = num + left;
					int nextright = num + right;
					if (nextleft < 0 || nextright >= n) {
						break;
					}

					if (arr[nextleft] == arr[nextright]) {
						if (arr[nextleft] == 1) {
							arr[nextleft] = 0;
							arr[nextright] = 0;
						} else {
							arr[nextleft] = 1;
							arr[nextright] = 1;
						}

						left--;
						right++;
					} else {
						break;
					}
				}
			}

		}

		for (int i = 0; i < n; i++) {
			if (i != 0 && i % 20 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
	}
}
