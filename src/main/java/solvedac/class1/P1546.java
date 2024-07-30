package solvedac.class1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1546 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\CTReady_withJava\\src\\main\\java\\solvedac\\class1\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double result = 0;
        int M = (int)Arrays.stream(arr).max().orElse(-1);

        for (int i = 0; i <N ; i++) {
            arr[i] = arr[i]/M*100;
        }

        result = Arrays.stream(arr).average().orElse(-1);

        System.out.println(result);
    }
}
