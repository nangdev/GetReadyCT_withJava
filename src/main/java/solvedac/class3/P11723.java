package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			if (s.equals("add")) {
				set.add(st.nextToken());
			} else if (s.equals("remove")) {
				set.remove(st.nextToken());
			} else if (s.equals("check")) {
				if (set.contains(st.nextToken())) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (s.equals("toggle")) {
				String c = st.nextToken();
				if (set.contains(c)) {
					set.remove(c);
				} else {
					set.add(c);
				}
			} else if (s.equals("all")) {
				set.clear();
				for (int j = 1; j < 21; j++) {
					set.add(j + "");
				}
			} else if (s.equals("empty")) {
				set.clear();
			}
		}

		System.out.println(sb);
	}

}
