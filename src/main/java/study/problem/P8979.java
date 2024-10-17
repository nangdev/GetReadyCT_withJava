package study.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P8979 {
	static class Medal implements Comparable<Medal> {
		int num, gold, silver, bronze;

		public Medal(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Medal o) {
			if (gold - o.gold != 0) {
				return o.gold - gold;
			} else if (silver - o.silver != 0) {
				return o.silver - silver;
			} else {
				return o.bronze - bronze;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Medal[] arr = new Medal[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			arr[i] = new Medal(a, b, c, d);
		}

		Arrays.sort(arr);

		int cnt = 0;
		int num = 1;
		Medal last = arr[0];

		if (arr[0].num == k) {
			System.out.println(1);
			return;
		}

		for (int i = 1; i < n; i++) {
			num++;
			if (last.gold != arr[i].gold || last.silver != arr[i].silver || last.bronze != arr[i].bronze) {
				cnt = 0;
			} else {
				cnt++;
			}

			if (arr[i].num == k) {
				System.out.println(num - cnt);
				return;
			}

			last = arr[i];
		}
	}
}
