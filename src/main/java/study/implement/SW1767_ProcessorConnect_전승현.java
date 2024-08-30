package study.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW1767_ProcessorConnect_전승현 {
	static int n, result, coreNum;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static List<Point> lis;
	static int lisLen;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			coreNum = 0;
			map = new int[n][n];

			lis = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
						lis.add(new Point(i, j));
					}
				}
			}

			lisLen = lis.size();
			dfs(0, 0, 0);

			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int idx, int coreTemp, int length) {
		if (idx == lisLen) {
			if (coreTemp > coreNum) {
				coreNum = coreTemp;
				result = length;
			} else if (coreTemp == coreNum) {
				result = Math.min(result, length);
			}
			return;
		}

		Point core = lis.get(idx);

		for (int d = 0; d < 4; d++) {
			int wireLength = 0;
			int x = core.x;
			int y = core.y;
			boolean canConnect = true;

			// 갈 수 있는지 확인
			while (true) {
				x += dx[d];
				y += dy[d];

				if (x < 0 || x >= n || y < 0 || y >= n)
					break;
				if (map[x][y] != 0) {
					canConnect = false;
					break;
				}
				wireLength++;
			}

			// 갈 수 있으면가 갈가
			if (canConnect) {
				x = core.x;
				y = core.y;
				while (true) {
					x += dx[d];
					y += dy[d];
					if (x < 0 || x >= n || y < 0 || y >= n)
						break;
					map[x][y] = 2;
				}
				// 쭉 보내고 다음꺼 ㄱㄱ
				dfs(idx + 1, coreTemp + 1, length + wireLength);

				// 쭉 보낸거 복구
				x = core.x;
				y = core.y;
				while (true) {
					x += dx[d];
					y += dy[d];
					if (x < 0 || x >= n || y < 0 || y >= n)
						break;
					map[x][y] = 0;
				}
			}
		}
		// 안보낸체 보내
		dfs(idx + 1, coreTemp, length);

	}
}
