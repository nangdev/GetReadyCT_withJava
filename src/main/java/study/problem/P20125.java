package study.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P20125 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		char[][] arr = new char[n][n];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int hx = 0, hy = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;

					if (arr[nx][ny] == '*') {
						cnt++;
					}
				}

				if (cnt == 4) {
					hx = i;
					hy = j;
					break;
				}
			}
			if (hx != 0 && hy != 0) {
				break;
			}
		}
		sb.append((hx + 1) + " " + (hy + 1) + "\n");

		// 왼쪽팔

		int idx = -1;
		int res = 0;
		while (hy + idx >= 0 && arr[hx][hy + idx] == '*') {
			res++;
			idx--;
		}

		sb.append(res + " ");

		// 오른쪽팔
		idx = 1;
		res = 0;
		while (hy + idx < n && arr[hx][hy + idx] == '*') {
			res++;
			idx++;
		}
		sb.append(res + " ");

		// 허리

		idx = 1;
		res = 0;
		while (hx + idx < n && arr[hx + idx][hy] == '*') {
			res++;
			idx++;
		}
		sb.append(res + " ");

		int leftlegstart = hx + idx - 1; // hy-1
		int rightlegstart = hx + idx - 1; // hy+1
		// 왼쪽 다리
		idx = 1;
		res = 0;
		while (leftlegstart + idx < n && arr[leftlegstart + idx][hy - 1] == '*') {
			res++;
			idx++;
		}
		sb.append(res + " ");

		// 오른쪽 다리

		idx = 1;
		res = 0;
		while (rightlegstart + idx < n && arr[rightlegstart + idx][hy + 1] == '*') {
			res++;
			idx++;
		}
		sb.append(res + " ");

		System.out.println(sb);
	}
}
