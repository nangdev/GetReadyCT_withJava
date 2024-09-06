package study.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2580 {
	static int n = 9;
	static int[][] arr = new int[9][9];
	static int[][] area = new int[9][9];

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static StringBuilder sb = new StringBuilder();

	static Deque<Point> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					q.add(new Point(i, j));
				}
			}
		}

		areaSet();

		dfs();
	}

	static void areaSet() {
		int cnt = 1;

		for (int i = 0; i < n; i += 3) {
			for (int j = 0; j < n; j += 3) {
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						area[i + a][j + b] = cnt;
					}
				}
				cnt++;
			}
		}
	}

	static boolean chkrow(int x, int y) {
		boolean[] num = new boolean[10];

		for (int i = 0; i < 9; i++) {
			num[arr[x][i]] = true;
		}

		return check(num, x, y);
	}

	static boolean chkcol(int x, int y) {
		boolean[] num = new boolean[10];

		for (int i = 0; i < 9; i++) {
			num[arr[i][y]] = true;
		}

		return check(num, x, y);
	}

	static boolean chkSquare(int x, int y) {
		int areanum = area[x][y];

		boolean[] num = new boolean[10];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (area[i][j] == areanum) {
					num[arr[i][j]] = true;
				}
			}
		}

		return check(num, x, y);
	}

	static boolean check(boolean[] num, int x, int y) {
		int chk = 0;
		int idx = 0;
		for (int i = 1; i <= 9; i++) {
			if (num[i] == false) {
				chk++;
				idx = i;
			}
		}

		if (chk == 1) {
			arr[x][y] = idx;
			return false;
		} else {
			return true;
		}
	}

	static void dfs() {
		if (q.isEmpty()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		Point p = q.pollFirst();
		int cx = p.x;
		int cy = p.y;

		if (chkrow(cx, cy) && chkcol(cx, cy) && chkSquare(cx, cy)) {
			q.add(p);
		}

		for (int i = 1; i < 9; i++) {

		}
	}
}
