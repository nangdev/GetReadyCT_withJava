package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int val = (int) Math.floor((((double) y * 100 / x)));

		if (val >= 99) {
			System.out.println(-1);
			return;
		}

		int min = 1;
		int max = x;

		while (min < max) {
			int mid = (min + max) / 2;

			int cur = (int) Math.floor((((double) (y + mid) * 100 / (x + mid))));

			if (cur > val) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min);

	}
}
