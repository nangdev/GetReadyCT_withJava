package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P17070 {
	static int n, result;
	static int[][] map;

	static class Point {
		int x, y, dir;

		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

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

		bfs(0, 1, 0);

		System.out.println(result);

	}

	static void bfs(int x, int y, int dir) {
		Deque<Point> q = new ArrayDeque<>();

		q.add(new Point(x, y, dir));

		while (!q.isEmpty()) {
			Point p = q.pollFirst();

			int cx = p.x;
			int cy = p.y;
			int cdir = p.dir;

			if (cx == n - 1 && cy == n - 1) {
				result++;
				continue;
			}

			if (cdir == 0) {
				if (cy + 1 < n && map[cx][cy + 1] != 1) {
					q.add(new Point(cx, cy + 1, 0));
				}

				if (cx + 1 < n && cy + 1 < n && chk(cx, cy)) {
					q.add(new Point(cx + 1, cy + 1, 2));
				}

			} else if (cdir == 1) {
				if (cx + 1 < n && map[cx + 1][cy] != 1) {
					q.add(new Point(cx + 1, cy, 1));
				}

				if (cx + 1 < n && cy + 1 < n && chk(cx, cy)) {
					q.add(new Point(cx + 1, cy + 1, 2));
				}
			} else {
				if (cy + 1 < n && map[cx][cy + 1] != 1) {
					q.add(new Point(cx, cy + 1, 0));
				}
				if (cx + 1 < n && map[cx + 1][cy] != 1) {
					q.add(new Point(cx + 1, cy, 1));
				}

				if (cx + 1 < n && cy + 1 < n && chk(cx, cy)) {
					q.add(new Point(cx + 1, cy + 1, 2));
				}
			}

		}

	}

	static boolean chk(int x, int y) {
		if (map[x][y + 1] == 1 || map[x + 1][y + 1] == 1 || map[x + 1][y] == 1) {
			return false;
		} else {
			return true;
		}
	}

}
