package solvedac.class2;

import java.io.*;
import java.util.StringTokenizer;

public class P2798 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\CTReady_withJava\\src\\main\\java\\solvedac\\class1\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i <N ; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int res = arr[i] + arr[j] + arr[k];
                    if(res <= M && res > result){
                        result = res;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
