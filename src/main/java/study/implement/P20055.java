package study.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] power = new int[n * 2];
        boolean[] exist = new boolean[n * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        int i = 1;
        while (true) {
            int temp = power[n * 2 - 1];
            for (int j = n * 2 - 1; j > 0; j--) {
                power[j] = power[j - 1];
                exist[j] = exist[j - 1];
            }
            power[0] = temp;
            exist[0] = false;
            exist[n - 1] = false;


            for (int j = n * 2 - 1; j > 0; j--) {
                if (exist[j] && !exist[j + 1] && power[j + 1] != 0) {
                    exist[j] = false;
                    exist[j + 1] = true;
                    power[j + 1] -= 1;

                    if (j + 1 == n - 1) {
                        exist[j + 1] = false;
                    }

                }
            }


            if (power[0] != 0) {
                exist[0] = true;
                power[0] -= 1;
            }

            int cnt = 0;
            for (int j = 0; j < n * 2; j++) {
                if (power[j] == 0) {
                    cnt++;
                }
            }

            if (cnt >= k) {
                break;
            }

            i++;
        }
        System.out.println(i);
    }
}
