package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                boolean flag = false;

                for (int j = 1; j <= k; j++) {
                    int idx = i - j;
                    if (idx >= 0 && arr[idx] == 'H') {
                        result++;
                        arr[idx] = 'P';
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    for (int j = 1; j <= k; j++) {
                        int idx = i + j;
                        if (idx < n && arr[idx] == 'H') {
                            result++;
                            arr[idx] = 'P';
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
