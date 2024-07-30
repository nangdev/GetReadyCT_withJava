package solvedac.class1;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class P1978 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path currentPath = Paths.get(P1978.class.getResource("").toURI());
        System.setIn(new FileInputStream(currentPath + "\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i : arr) {
            int cnt = 0;
            for (int j = 1; j < i; j++) {
                if(i%j == 0){
                    cnt++;
                }
            }
            if(cnt == 1){
                result++;
            }
        }

        System.out.println(result);
    }
}
