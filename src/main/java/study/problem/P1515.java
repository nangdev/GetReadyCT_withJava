package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int idx = 0;
        int num = 1;

        while (idx < arr.length) {
            String currentNum = String.valueOf(num);

            for (char c : currentNum.toCharArray()) {
                if (idx < arr.length && arr[idx] == c) {
                    idx++;
                }
            }
            num++;
        }

        System.out.println(num - 1);
    }
}
