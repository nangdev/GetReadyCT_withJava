package study.pcfs;

import java.util.Scanner;

public class P10819 {
    static int n, answer = 0;
    static int[] result,input;
    static boolean[] isSelec;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        result = new int[n];
        input = new int[n];
        isSelec = new boolean[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        perm(0);
        System.out.println(answer);
    }
    static void perm(int cnt){
        if(cnt == n){
            int temp = 0;
            for (int i = 0; i < n-1; i++) {
                temp += Math.abs(result[i]-result[i+1]);
            }
            answer = Math.max(answer,temp);
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
