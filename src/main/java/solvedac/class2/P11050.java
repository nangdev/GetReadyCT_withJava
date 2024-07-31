package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = facto(N) / (facto(N-K)*facto(K));
        System.out.println(result);
    }

    public static int facto(int a){
        int result = 1;
        for (int i = 2; i <= a; i++) {
            result *= i;
        }

        return result;
    }
}
