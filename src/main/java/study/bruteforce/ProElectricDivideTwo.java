package study.bruteforce;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProElectricDivideTwo {
	static boolean[][] map;
	static boolean[] v;

	public int solution(int n, int[][] wires) {
		map = new boolean[n + 1][n + 1];

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < n - 1; i++) {
			int a = wires[i][0];
			int b = wires[i][1];

			map[a][b] = true;
			map[b][a] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			int a = wires[i][0];
			int b = wires[i][1];

			map[a][b] = false;
			map[b][a] = false;

			int first = bfs(a, n);
			int second = bfs(b, n);

			map[a][b] = true;
			map[b][a] = true;

			int val = Math.abs(first - second);

			result = result > val ? val : result;
		}

		return result;
	}

	static int bfs(int start, int total) {
		boolean[] v = new boolean[total + 1];
		int visit = 0;
		Deque<Integer> q = new ArrayDeque<>();

		q.add(start);
		v[start] = true;

		while (!q.isEmpty()) {
			int cur = q.pollFirst();

			for (int i = 1; i < total + 1; i++) {
				if (map[cur][i] && !v[i]) {
					v[i] = true;
					visit++;
					q.add(i);
				}
			}
		}

		return visit;
	}

}
