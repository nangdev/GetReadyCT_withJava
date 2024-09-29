package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long num1 = 0, num2 = 0;

        int s = 0, e = n - 1;
        long min = Integer.MAX_VALUE;

        while (s < e) {
            long sum = arr[s] + arr[e];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);

                num1 = arr[s];
                num2 = arr[e];

                if (sum == 0) break;
            }

            if (sum < 0) s++;
            else e--;
        }

        System.out.println(num1 + " " + num2);

    }
}
