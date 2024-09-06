package study.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14889 {
	static int n, divn, result = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] isSelec;
	static int[] people;
	static List<Integer> link = new ArrayList<>();
	static List<Integer> start = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		divn = n / 2;

		arr = new int[n][n];
		people = new int[n];
		isSelec = new boolean[n];

		for (int i = 0; i < n; i++) {
			people[i] = i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0);

		System.out.println(result);

	}

	static int sumlis(List<Integer> lis) {
		int sum = 0;
		for (int i = 0; i < divn; i++) {
			for (int j = 0; j < divn; j++) {
				if (i == j)
					continue;
				sum += arr[lis.get(i)][lis.get(j)];
			}
		}

		return sum;
	}

	static void combi(int cnt, int next) {
		if (cnt == divn) {
			link.clear();
			for (int i = 0; i < n; i++) {
				if (!isSelec[i]) {
					link.add(people[i]);
				}
			}

			int val = Math.abs(sumlis(start) - sumlis(link));

			result = result > val ? val : result;
			return;
		}

		for (int i = next; i < n; i++) {
			if (isSelec[i])
				continue;

			isSelec[i] = true;
			start.add(people[i]);
			combi(cnt + 1, i + 1);
			isSelec[i] = false;
			start.remove(Integer.valueOf(people[i]));
		}
	}

}
