package study.pcfs;

import java.util.Scanner;

public class P6603 {
    static int k;
    static int[] result,input;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            k = sc.nextInt();
            if(k == 0){
                break;
            }

            result = new int[6];
            input = new int[k];
            sb = new StringBuilder();

            for (int i = 0; i < k; i++) {
                input[i] = sc.nextInt();
            }

            combi(0,0);
            System.out.println(sb);
        }
    }

    static void combi(int cnt,int start){
        if(cnt == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(result[i] + " ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            result[cnt] = input[i];
            combi(cnt+1,i+1);
        }
    }
}
