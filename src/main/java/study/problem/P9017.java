package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P9017 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine()) + 1;
			st = new StringTokenizer(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();

			int[] arr = new int[n];
			for (int j = 1; j < n; j++) {
				int val = Integer.parseInt(st.nextToken());
				arr[j] = val;

				if (map.containsKey(val)) {
					map.put(val, map.get(val) + 1);
				} else {
					map.put(val, 1);
				}
			}

			List<Integer> keys = new ArrayList<>();

			for (Integer key : map.keySet()) {
				if (map.get(key) == 6) {
					int sum = 0;
					for (int j = 1; j < n; j++) {
						if (arr[j] == key) {
							sum += j;
						}
					}

					map.put(key, sum);
				} else {
					keys.add(key);
				}
			}

			for (Integer key : keys) {
				map.remove(key);
			}

			int minval = Integer.MAX_VALUE;
			int result = 0;
			int cnt = 0;
			for (Integer key : map.keySet()) {
				if (map.get(key) < minval) {
					result = key;
					cnt++;
				}
			}

			if (cnt == 1) {
				sb.append(result + "\n");
				continue;
			}

			int finalval = Integer.MAX_VALUE;
			for (Integer key : map.keySet()) {
				if (map.get(key) == minval) {
					int idxcnt = 0;
					for (int j = 1; j < n; j++) {
						if (arr[j] == key) {
							idxcnt++;
						}

						if (idxcnt == 5) {
							if (finalval > j) {
								result = key;
							}
						}

					}
				}
			}

			sb.append(result + "\n");
		}

		System.out.println(sb);
	}
}
