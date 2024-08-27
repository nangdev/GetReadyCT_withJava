package study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> lis = new ArrayList<>();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> result = new ArrayList<>();
		int siz = 0;

		for (int i = 0; i < n; i++) {
			lis.add(0);
			lis.add(arr[i]);
			for (int j = i + 1; j < n; j++) {
				int c = lis.size();
				if (arr[j] > lis.get(c - 1) && arr[j] > lis.get(c - 2)) {
					lis.add(arr[j]);
				} else {
					if (arr[j] < lis.get(c - 1) && arr[j] > lis.get(c - 2)) {
						lis.remove(c - 1);
						lis.add(arr[j]);
					}
				}
			}
			if (siz < lis.size()) {
				siz = lis.size();
				result.clear();
				result.addAll(lis.subList(1, lis.size()));
			}
			lis.clear();
		}

		StringBuilder sb = new StringBuilder();
		sb.append(siz - 1).append("\n");
		result.forEach((s) -> sb.append(s + " "));
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}

}
