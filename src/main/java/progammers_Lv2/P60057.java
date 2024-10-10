package progammers_Lv2;

import java.util.Arrays;

class P60057 {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));

	}

	public static int solution(String s) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		int divlen = len / 2;
		int[] num = new int[divlen + 1];
		num[0] = len;

		for (int i = 1; i <= divlen; i++) {
			int idx = i;
			String last = s.substring(0, i);
			String res = "";
			int curnum = 1;
			while (idx < len) {
				if (idx + i < len) {
					String cur = s.substring(idx, idx + i);

					if (cur.equals(last)) {
						curnum++;
					} else {
						if (curnum == 1) {
							res += last;
							last = cur;
							continue;
						}
						res += curnum + last;
						last = cur;
						curnum = 1;
					}

					idx += i;
				} else {
					break;
				}
			}

			System.out.println(res);
			num[i] = res.length();
		}
		Arrays.sort(num);
		return num[0];
	}
}