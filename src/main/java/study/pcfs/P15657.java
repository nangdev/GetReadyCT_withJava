package study.pcfs;

import java.util.Arrays;
import java.util.Scanner;

public class P15657 {
    static int[] result,input;
    static int n,m;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        result = new int[m];
        input = new int[n];

        for (int i = 0; i <n ; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        sb = new StringBuilder();
        combi(0,0);
        System.out.println(sb);

    }

    static void combi(int cnt,int start){
        if(cnt == m){
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = start; i <n ; i++) {
            result[cnt] = input[i];
            combi(cnt+1, i);
        }
    }

}
