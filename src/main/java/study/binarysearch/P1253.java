package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 2) {
            System.out.println(0);
            return;
        }

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int res = 0;

        for (int i = 0; i < n; i++) {
            long cur = arr[i];

            int s = 0;
            int e = n - 1;

            while (s < e) {
                long sum = arr[s] + arr[e];

                if (s == i) {
                    s++;
                    continue;
                } else if (e == i) {
                    e--;
                    continue;
                }

                if (arr[s] + arr[e] > cur) {
                    e--;
                } else {
                    s++;
                }

                if (sum == cur) {
                    res++;
                    break;
                }
            }
            
        }

        System.out.println(res);
    }
}
