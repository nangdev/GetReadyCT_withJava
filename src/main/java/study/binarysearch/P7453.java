package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7453 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(d);
		Arrays.sort(c);
		int res = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int min1 = 0;
				int max1 = n;

				int val = a[i] + b[j];
				int didx = 0;
				while (min1 < max1) {
					int mid1 = (min1 + max1) / 2;

					int min2 = 0;
					int max2 = n;

					int val2 = val + c[mid1];

					while (min2 < max2) {
						int mid2 = (min2 + max2) / 2;

						if (val2 + d[mid2] > 0) {
							max2 = mid2;
						} else {
							min2 = mid2 + 1;
						}
					}

					if (min2 != 0 && val2 + d[min2 - 1] > 0) {
						max1 = mid1;
					} else {
						min1 = mid1 + 1;
						didx = mid1;
					}
				}
				if (min1 != 0 && val + c[min1 - 1] + didx == 0) {
					res++;
				}
			}
		}

		System.out.println(res);

	}

}
