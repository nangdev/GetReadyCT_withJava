package study.pcfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10972 {
    static int n;
    static int[] result,input,exam;
    static boolean[] isSelec;
    static boolean flag = false, fin = false;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        result = new int[n];
        input = new int[n];
        exam = new int[n];
        isSelec = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = i+1;
            exam[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();

        perm(0);
        if(sb.length() >0){
            System.out.println(sb);
        }
        else {
            System.out.println(-1);
        }
    }

    static void perm(int cnt){
        if(cnt == n){
            if(flag){
                for (int i = 0; i < n; i++) {
                    sb.append(result[i] + " ");
                }
                sb.setLength(sb.length()-1);
                sb.append("\n");
                fin = true;
            }else{
                for (int i = 0; i < n; i++) {
                    if(result[i] != exam[i]){
                        return;
                    }
                }
                flag = true;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isSelec[i]) continue;

            isSelec[i] = true;
            result[cnt] = input[i];
            perm(cnt+1);
            if(fin){
                return;
            }
            isSelec[i] = false;
        }
    }

}
