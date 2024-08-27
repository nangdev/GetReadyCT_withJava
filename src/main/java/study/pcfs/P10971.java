package study.pcfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10971 {
    static int n,result = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        v = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            v[i] = true;
            dfs(i,0,0);
            v[i] = false;
        }

        System.out.println(result);
    }

    static void dfs(int start, int cost, int cnt){
        if(cost >= result){
            return;
        }

        if(cnt == n-1){
            if(arr[cnt][start] != 0){
                result = Math.min(result, cost + arr[cnt][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!v[i] && arr[cnt][i] != 0){
                v[i] = true;
                dfs(start,cost+arr[start][i],cnt+1);
                v[i] = false;
            }
        }
    }
}
