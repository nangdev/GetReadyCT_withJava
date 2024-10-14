package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine().toUpperCase();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int max = 0;
		int cnt = 0;

		for (char c : map.keySet()) {
			if (map.get(c) > max) {
				max = map.get(c);
			}
		}

		char ans = 'd';

		for (char c : map.keySet()) {
			if (map.get(c) == max) {
				ans = c;
				cnt++;
			}
		}

		if (cnt == 1) {
			System.out.println(ans);
		} else {
			System.out.println('?');
		}
	}
}
