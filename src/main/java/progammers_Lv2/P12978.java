package progammers_Lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class P12978 {
	static class Point {
		int num, len;

		Point(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
		int k = 4;

		System.out.println(solution(n, road, k));
	}

	static int solution(int N, int[][] road, int K) {
		int ans = 1;

		int n = road.length;
		boolean[] v = new boolean[n];
		boolean[] vnum = new boolean[N + 1];
		vnum[1] = true;
		Deque<Point> q = new ArrayDeque<>();
		q.add(new Point(1, 0));

		while (!q.isEmpty()) {
			Point p = q.pollFirst();

			for (int i = 0; i < n; i++) {
				if (!v[i]) {
					if (road[i][0] == p.num && road[i][2] + p.len <= K && !vnum[road[i][1]]) {
						ans += 1;
						q.add(new Point(road[i][1], road[i][2] + p.len));
						v[i] = true;
						vnum[road[i][1]] = true;
					} else if (road[i][1] == p.num && road[i][2] + p.len <= K && !vnum[road[i][0]]) {
						ans += 1;
						q.add(new Point(road[i][0], road[i][2] + p.len));
						v[i] = true;
						vnum[road[i][0]] = true;

					}
				}
			}
		}
		for (boolean b : v) {
			System.out.println(b);
		}
		return ans;
	}

}
