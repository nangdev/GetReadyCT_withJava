package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long min = 1;
        long max = arr[n - 1] - arr[0] + 1;

        while (min < max) {
            long mid = (min + max) / 2;

            int cnt = 1;
            long last = arr[0];

            for (int i = 1; i < n; i++) {
                long cur = arr[i];

                if (cur - last >= mid) {
                    cnt++;
                    last = cur;
                }
            }

            if (cnt < c) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

}
