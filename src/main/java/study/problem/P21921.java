package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int max = sum;
        int same = 1;

        for (int i = 1; i <= n - x; i++) {
            sum += arr[i + x - 1] - arr[i - 1];

            if (sum > max) {
                max = sum;
                same = 1;
            } else if (sum == max) {
                same++;
            }
        }


        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(same);
        }
    }
}
