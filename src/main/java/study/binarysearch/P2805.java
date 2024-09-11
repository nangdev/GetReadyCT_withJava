package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long min = 0;
		long max = arr[n - 1] + 1;

		while (min < max) {
			long mid = (min + max) / 2;

			long cnt = 0;

			for (int i = 0; i < n; i++) {
				if (arr[i] - mid > 0)
					cnt += (arr[i] - mid);
			}

			if (cnt < m) {
				max = mid;
			} else {
				min = mid + 1;
			}

		}

		System.out.println(min - 1);
	}

}
