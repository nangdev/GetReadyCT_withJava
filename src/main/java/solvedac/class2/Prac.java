package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prac {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		List<Integer> arr = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < 5; i++) {
			set.add(i);
		}

		for (int i = 0; i < 5; i++) {
			sb.append(i);
		}

		sb.replace(0, sb.length(), "");
		System.out.println(sb);
	}
}
