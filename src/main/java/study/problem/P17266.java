package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17266 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 1;
        int max = n;

        while (min <= max) {
            int mid = (min + max) / 2;
            boolean flag = true;

            // 첫 가로등이 첫 위치를 커버할 수 있는지 확인
            if (arr[0] > mid) {
                flag = false;
            }

            // 중간 가로등이 각 구간을 커버할 수 있는지 확인
            for (int i = 1; i < m && flag; i++) {
                if (arr[i] - arr[i - 1] > 2 * mid) {
                    flag = false;
                }
            }

            // 마지막 가로등이 마지막 위치를 커버할 수 있는지 확인
            if (n - arr[m - 1] > mid) {
                flag = false;
            }

            // 커버할 수 있는 경우
            if (flag) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }
}
