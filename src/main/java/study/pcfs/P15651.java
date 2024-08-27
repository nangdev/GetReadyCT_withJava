package study.pcfs;

import java.util.Scanner;

public class P15651 {
    static int[] result, input;
    static boolean[] isSelec;
    static StringBuilder sb;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        result = new int[m];
        input = new int[n];
        isSelec = new boolean[n];

        for (int i = 0; i < n; i++) {
            input[i] = i+1;
        }

        sb = new StringBuilder();

        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt){
        if(cnt == m){
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            result[cnt] = input[i];
            perm(cnt+1);
        }

    }
}
