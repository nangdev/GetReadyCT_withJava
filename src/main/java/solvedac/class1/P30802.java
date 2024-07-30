package solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.StringTokenizer;

public class P30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int Tto = 0, Pto = 0, Premain = 0;

        for (int i : arr) {
            if(i%T == 0){
                Tto += i/T;
            }
            else{
                Tto += i/T + 1;
            }
        }
        Pto = N/P;
        Premain = N % P;

        System.out.println(Tto);
        System.out.println(Pto +" "+Premain);
    }
}
