package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int len = s.length();

        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            String tem = br.readLine();
            int replaceCnt = 0;
            for (int j = 0; j < len; j++) {
                if (tem.contains(String.valueOf(s.charAt(j)))) {
                    tem = tem.replaceFirst(String.valueOf(s.charAt(j)), "");
                    replaceCnt++;
                }
            }

            if (replaceCnt >= len - 1 && tem.length() < 2) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
