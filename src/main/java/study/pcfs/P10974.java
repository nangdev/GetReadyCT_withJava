package study.pcfs;

import java.util.Scanner;

public class P10974 {
    static int n;
    static int[] result,input;
    static boolean[] isSelec;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        result = new int[n];
        input = new int[n];
        isSelec = new boolean[n];

        for (int i = 0; i <n ; i++) {
            input[i] = i+1;
        }

        sb = new StringBuilder();
        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt){
        if(cnt == n){
            for (int i = 0; i <n ; i++) {
                sb.append(result[i] + " ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = 0; i <n ; i++) {
            if(isSelec[i]) continue;

            isSelec[i] = true;
            result[cnt] = input[i];
            perm(cnt+1);
            isSelec[i] = false;
        }
    }
}
