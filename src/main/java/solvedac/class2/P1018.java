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
        String[] map = new String[N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        int result = 100;

        // offset = N-8+1

        for (int i = 0; i < N-8+1; i++) {
            for (int j = 0; j < M-8+1; j++) {
                char c = map[i].charAt(j);
                int cnt = 0;
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        if(map[k].charAt(l) != c){
                            cnt++;
                        }else{
                        	
                            c = c =='W'?'B':'W';
                        }
                    }
                    c = c =='W'?'B':'W';
                }
                result = result > cnt ? cnt : result;
            }
        }
        System.out.println(result);
    }
}
