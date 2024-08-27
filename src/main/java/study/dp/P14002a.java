package study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14002a {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] trace = new int[n]; // 추적 배열

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> lis = new ArrayList<>();
		int[] lisIndices = new int[n]; // LIS에 포함된 인덱스 저장

		int lisLength = 0; // LIS 길이
		for (int i = 0; i < n; i++) {
			int pos = lowerBound(lis, arr[i]); // 이진 탐색으로 위치 찾기
			if (pos < lis.size()) {
				lis.set(pos, arr[i]);
			} else {
				lis.add(arr[i]);
			}

			dp[i] = pos + 1; // 현재 LIS 길이
			lisIndices[pos] = i; // LIS 인덱스 갱신
			trace[i] = pos > 0 ? lisIndices[pos - 1] : -1; // 이전 인덱스 저장
			lisLength = Math.max(lisLength, dp[i]);
		}

		// LIS 결과 재구성
		List<Integer> result = new ArrayList<>();
		for (int i = n - 1, k = lisLength; i >= 0; i--) {
			if (dp[i] == k) {
				result.add(0, arr[i]);
				k--;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(lisLength).append("\n");
		for (int num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	// 이진 탐색 (Lower Bound) 구현
	private static int lowerBound(List<Integer> list, int key) {
		int low = 0;
		int high = list.size();

		while (low < high) {
			int mid = (low + high) / 2;
			if (list.get(mid) < key) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}
