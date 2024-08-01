package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        char c = 'a';
        String s = br.readLine();

        if(s.charAt(0) == 'W'){
            c = 'B';
        }
        else{
            c = 'W';
        }



        for (int i = 0; i < N; i++) {
            for (char cb : s.toCharArray()) {

            }

            s = br.readLine();
        }


    }
}
