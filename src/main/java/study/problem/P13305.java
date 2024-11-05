package study.problem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int nmi = n - 1;

        int[] road = new int[nmi];
        long[] cost = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nmi; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0;
        int idx = 0;
        int start = 0;
        while (idx < nmi) {
            for (int i = start; i < nmi; i++) {
                if (cost[start] > cost[i]) {
                    start = idx;
                    break;
                } else {
                    res += cost[start] * road[i];
                    idx++;
                }
            }
        }

        System.out.println(res);
    }
}
