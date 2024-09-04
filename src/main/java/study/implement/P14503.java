package study.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503 {
	static int n, m, result;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = 0;

		map = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(x, y, d);

		System.out.println(result);
	}

	static void move(int x, int y, int dir) {
		while (true) {
			if (map[x][y] == 0) {
				map[x][y] = 3;
				result++;
			}

			boolean level1 = false;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 0) {
					level1 = true;
					break;
				}
			}

			if (level1) {
				if (--dir < 0) {
					dir = 3;
				}

				int nextx = x + dx[dir];
				int nexty = y + dy[dir];

				if (0 <= nextx && nextx < n && 0 <= nexty && nexty < m && map[nextx][nexty] == 0) {
					x = nextx;
					y = nexty;
				}

			} else {
				int tempdir = 0;
				if (dir > 1) {
					tempdir = dir % 2;
				} else {
					tempdir = dir + 2;
				}

				int nx = x + dx[tempdir];
				int ny = y + dy[tempdir];

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (map[nx][ny] != 1) {
						x = nx;
						y = ny;
					} else if (map[nx][ny] == 1) {
						return;
					}
				}
			}

		}
	}
}
