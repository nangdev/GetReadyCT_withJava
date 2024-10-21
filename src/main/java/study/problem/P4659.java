package study.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4659 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] moem = { 'a', 'e', 'i', 'o', 'u' };

		while (true) {
			String s = br.readLine();

			if (s.equals("end")) {
				break;
			}

			// 조건 1
			boolean flag1 = false;

			for (char c : s.toCharArray()) {
				for (int i = 0; i < 5; i++) {
					if (c == moem[i]) {
						flag1 = true;
						break;
					}
				}
				if (flag1) {
					break;
				}
			}

			if (!flag1) {
				sb.append("<" + s + ">" + " is not acceptable.\n");
				continue;
			}
			// 조건 2
			boolean flag2 = false;

			int cnt = 0;
			boolean cur = false; // 참 모음, 거짓 자음

			for (int i = 0; i < 5; i++) {
				if (s.charAt(0) == moem[i]) {
					cur = true;
					break;
				}
			}

			for (char c : s.toCharArray()) {
				boolean isMoem = false;
				for (int i = 0; i < 5; i++) {
					if (c == moem[i]) {
						isMoem = true;
						break;
					}
				}

				if (cur != isMoem) {
					cnt = 1;
					cur = isMoem;
				} else {
					cnt++;
				}

				if (cnt == 3) {
					flag2 = true;
					break;
				}

			}

			if (flag2) {
				sb.append("<" + s + ">" + " is not acceptable.\n");
				continue;
			}

			// 조건 3
			boolean flag3 = false;

			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					if (s.charAt(i) == 'e' || s.charAt(i) == 'o') {
						continue;
					} else {
						flag3 = true;
						break;
					}
				}
			}

			if (flag3) {
				sb.append("<" + s + ">" + " is not acceptable.\n");
				continue;
			}

			sb.append("<" + s + ">" + " is acceptable.\n");
		}
		System.out.println(sb);
	}

}
