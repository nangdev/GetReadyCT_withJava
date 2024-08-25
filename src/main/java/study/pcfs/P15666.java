package study.pcfs;

import java.util.Arrays;
import java.util.Scanner;

public class P15666 {
    static int n,m;
    static int[] result,input;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        result = new int[m];
        input = new int[n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);

        combi(0,0);
        System.out.println(sb);
    }

    static void combi(int cnt, int start){
        if(cnt == m){
            for (int i = 0; i < m; i++) {
                sb.append(result[i]);
                if(i<m-1){
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        int lastIndex = -1;

        for (int i = start; i < n; i++) {
            if(input[i] != lastIndex) {
                result[cnt] = input[i];
                combi(cnt + 1, i);
                lastIndex = input[i];
            }
        }
    }
}
