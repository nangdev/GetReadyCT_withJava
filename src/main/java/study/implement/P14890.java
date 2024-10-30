package study.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14890 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		// ����
		for (int i = 0; i < n; i++) {
			boolean chk = false;
			boolean[] v = new boolean[n];
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] != map[i][j + 1]) {
					if (Math.abs(map[i][j] - map[i][j + 1]) == 1) {

						int cur = map[i][j + 1];
						boolean lchk = false;
						boolean rchk = false;

						if (map[i][j] - cur == 1) { // ��������

							for (int k = j; k < j + l; k++) {
								if (k >= n || cur != map[i][k] || v[k]) {
									lchk = true;
									break;
								} else {
									v[k] = true;
								}
							}
						} else { // ��������
							for (int k = j; k > j - l; k--) {
								if (k < 0 || cur != map[i][k] || v[k]) {
									rchk = true;
									break;
								} else {
									v[k] = true;
								}
							}
						}
						if (lchk) {
							for (int k = j; k < j + l; k++) {
								if (k < n) {
									v[k] = false;
								}
							}
							chk = true;
							break;
						} else if (rchk) {
							for (int k = j; k > j - l; k--) {
								if (k >= 0) {
									v[k] = false;
								}
							}
							chk = true;
							break;
						}
					} else {
						chk = true;
						break;
					}
				}
			}
			if (!chk) {
				result++;
			}
		}

		// ����
		for (int i = 0; i < n; i++) {
			boolean chk = false;
			boolean[] v = new boolean[n];
			for (int j = 0; j < n - 1; j++) {
				if (map[j][i] != map[j + 1][i]) {
					if (Math.abs(map[j][i] - map[j + 1][i]) == 1) {
						int cur = map[j + 1][i];
						boolean lchk = false;
						boolean rchk = false;

						if (map[i][j] - cur == 1) { // �������

							for (int k = j; k < j + l; k++) {
								if (k >= n || cur != map[k][i] || v[k]) {
									lchk = true;
									break;
								} else {
									v[k] = true;
								}
							}
						} else { // �ݴ� ����
							for (int k = j; k > j - l; k--) {
								if (k < 0 || cur != map[k][i] || v[k]) {
									rchk = true;
									break;
								} else {
									v[k] = true;
								}
							}
						}
						if (lchk) {
							for (int k = j; k < j + l; k++) {
								if (k < n) {
									v[k] = false;
								}
							}
							chk = true;
							break;
						} else if (rchk) {
							for (int k = j; k > j - l; k--) {
								if (k >= 0) {
									v[k] = false;
								}
							}
							chk = true;
							break;
						}
					} else {
						chk = true;
						break;
					}
				}
			}
			if (!chk) {
				result++;
			}
		}

		System.out.println(result);

	}
}
