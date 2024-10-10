package progammers_Lv2;

class P42860 {
	static String nam;
	static int cnt = 0, idx = 0, stage = 0, slen;

	public int solution(String name) {
		nam = name;
		slen = name.length();

		for (int i = 0; i < slen; i++) {
			if (name.charAt(i) == 'A') {
				stage++;
			}
		}

		while (stage != slen) {
			int round = 0;

			int L = moveLeft(idx);
			int R = moveRight(idx);

			int U = moveUp(name.charAt(idx));
			int D = moveDown(name.charAt(idx));
			// 왼쪽 가는거

			// 오른쪽 가는거

			// 비교 더 작은거 가서

			if (L < R) {
				round = L;
				idx = L;
			} else {
				round = R;
				idx = R;
			}

			// 위로 올리는거

			// 아래로 내리는거

			// 비교 더 작은거 실

			if (U < D) {
				round += U;
			} else {
				round += D;
			}
			// 총 횟수 더하기
			cnt += round;
			stage++;
		}

		return cnt;

	}

	int moveLeft(int idx) {
		int cnt = 1;
		int point = idx - 1;
		if (idx == 0) {
			point = slen - 1;
		}

		while (nam.charAt(point) != 'A') {
			if (point == 0) {
				point = slen - 1;
			} else {
				point--;
			}
		}

		return point;
	}

	int moveRight(int idx) {
		int cnt = 1;
		int point = idx + 1;
		if (point == slen) {
			point = 0;
		}

		while (nam.charAt(point) != 'A') {
			if (point == slen - 1) {
				point = 0;
			} else {
				point++;
			}
		}

		return point;
	}

	int moveUp(char tar) {
		return tar - 'A';
	}

	int moveDown(char tar) {
		return 'Z' - tar + 1;
	}
}
