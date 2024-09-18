package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] lis = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];

        int len = 1;

        for (int i = 1; i < n; i++) {
            int cur = arr[i];

            if (lis[len - 1] < cur) {
                len++;
                lis[len - 1] = cur;
            } else {
                int min = 0;
                int max = len;

                while (min < max) {
                    int mid = (min + max) / 2;

                    if (lis[mid] < cur) {
                        min = mid + 1;
                    } else {
                        max = mid;
                    }
                }
                lis[min] = cur;
            }
        }
        System.out.println(len);
    }
}
