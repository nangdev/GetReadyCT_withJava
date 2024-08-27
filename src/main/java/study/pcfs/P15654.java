package study.pcfs;

import java.util.Arrays;
import java.util.Scanner;

public class P15654 {
    static int[] result,input;
    static boolean[] isSelec;
    static int n,m;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        result = new int[m];
        input = new int[n];
        isSelec = new boolean[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        sb = new StringBuilder();
        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt){
        if(cnt == m){
            for (int i = 0; i <m ; i++) {
                sb.append(result[i]+" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isSelec[i]) continue;

            isSelec[i] = true;
            result[cnt] = input[i];
            perm(cnt+1);
            isSelec[i] = false;
        }
    }
}
