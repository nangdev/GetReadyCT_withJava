package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17266 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 1;
        int max = n;

        while (min < max) {
            int mid = (min + max) / 2;

            int[] temp = new int[n];

            for (int i = 0; i < m; i++) {

                for (int j = arr[i] - mid; j <= arr[i] + mid; j++) {
                    if (j >= 0 && j < n) {
                        temp[j] = 1;
                    }
                }
            }

            boolean flag = false;

            for (int i = 0; i < n; i++) {
                if (temp[i] == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min);
    }
}
