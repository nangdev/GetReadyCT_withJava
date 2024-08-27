package study.pcfs;

import java.util.Arrays;
import java.util.Scanner;

public class P15656 {
    static int[] res,inp;
    static int n,m;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        res = new int[m];
        inp = new int[n];

        for (int i = 0; i < n; i++) {
            inp[i] = sc.nextInt();
        }

        Arrays.sort(inp);

        sb = new StringBuilder();
        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt){
        if(cnt == m){
            for (int i = 0; i < m; i++) {
                sb.append(res[i] + " ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            res[cnt] = inp[i];
            perm(cnt+1);
        }
    }
}
