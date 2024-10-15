package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2816 {
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		arr = new String[n];

		int idx = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();

			if (arr[i].equals("KBS1")) {
				idx = i;
			}
		}

		for (int i = 0; i < idx; i++) {
			sb.append("1");
		}

		while (!arr[0].equals("KBS1")) {
			swap(idx, idx - 1);
			idx--;
			sb.append("4");
		}

		for (int i = 0; i < n; i++) {
			if (arr[i].equals("KBS2")) {
				idx = i;
				break;
			}
		}

		for (int i = 0; i < idx; i++) {
			sb.append("1");
		}

		while (!arr[1].equals("KBS2")) {
			swap(idx, idx - 1);
			idx--;
			sb.append("4");
		}

		System.out.println(sb);

	}

	static void swap(int a, int b) {
		String temp = "";
		temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
}
