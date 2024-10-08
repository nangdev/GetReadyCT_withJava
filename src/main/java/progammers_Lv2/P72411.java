package progammers_Lv2;

import java.util.ArrayList;
import java.util.List;

class Solution {
	static boolean[] v;
	static List<List<Integer>> lis = new ArrayList<>();
	static int ans = 1, n, k, lisn;
	static int[][] arr;

	public int solution(int N, int[][] road, int K) {
		n = N;
		k = K;
		lisn = road.length;
		v = new boolean[N + 1];
		v[1] = true;
		arr = road;
		for (int i = 0; i < N; i++) {
			lis.add(new ArrayList<Integer>());
		}

		for (int[] li : road) {
			lis.get(li[0]).add(li[1]);
			lis.get(li[1]).add(li[0]);
		}

		dfs(0, 1, 0);

		return ans;
	}

	void dfs(int cnt, int cur, int len) {
		if (len > k) {
			return;
		}

		if (cnt == n) {
			return;
		}

		for (int i = 0; i < lisn; i++) {
			if (arr[i][0] == cur && !v[arr[i][1]]) {

			}
		}
	}
}