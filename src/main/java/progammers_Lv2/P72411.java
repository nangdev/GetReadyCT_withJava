package progammers_Lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	static class Point {
		int to, len;

		Point(int to, int len) {
			this.to = to;
			this.len = len;
		}
	}

	static List<List<Point>> lis = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();
	static int roadlen, n, k;
	static boolean[] v;

	public int solution(int N, int[][] road, int K) {
		for (int i = 0; i < N + 1; i++) {
			lis.add(new ArrayList<Point>());
		}
		n = N;
		k = K;
		roadlen = road.length;

		v = new boolean[N + 1];

		for (int i = 0; i < roadlen; i++) {
			lis.get(road[i][0]).add(new Point(road[i][1], road[i][2]));
			lis.get(road[i][1]).add(new Point(road[i][0], road[i][2]));
		}

		set.add(1);
		v[1] = true;

		dfs(1, 0);

		return set.size();
	}

	static void dfs(int from, int len) {
		if (len == k) {
			return;
		}

		for (Point p : lis.get(from)) {
			if (!v[p.to] && p.len + len <= k) {
				set.add(p.to);
				v[p.to] = true;
				dfs(p.to, p.len + len);
				v[p.to] = false;
			}
		}
	}
}