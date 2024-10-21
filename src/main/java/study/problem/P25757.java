package study.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P25757 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		String kind = st.nextToken();

		int max = 0;

		if (kind.equals("Y")) {
			max = 1;
		} else if (kind.equals("F")) {
			max = 2;
		} else {
			max = 3;
		}

		Set<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		int len = set.size();
		int ans = 0;
		while (len >= max) {
			len -= max;
			ans++;
		}

		System.out.println(ans);
	}
}
