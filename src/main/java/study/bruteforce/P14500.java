package study.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
    static int n, m, result;
    static int[][] arr;
    static boolean[][] v;

    // 상, 하, 좌, 우
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                v[i][j] = false;
//                chkFuck(i, j);
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny]) continue;
            	if(depth == 2) {
            		v[nx][ny] = true;
            		dfs(x,y,depth+1,sum+arr[nx][ny]);
            		v[nx][ny] = false;
            	}

            v[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
            v[nx][ny] = false;
        }
    }


//    static void chkFuck(int x, int y) {
//        // ㅗ
//        if (x - 1 > 0 && y + 2 < m) {
//            int temp = arr[x][y] + arr[x - 1][y + 1] + arr[x][y + 1] + arr[x][y + 2];
//            result = Math.max(result, temp);
//        }
//        // ㅜ
//        if (x + 1 < n && y + 2 < m) {
//            int temp = arr[x][y] + arr[x + 1][y + 1] + arr[x][y + 1] + arr[x][y + 2];
//            result = Math.max(result, temp);
//        }
//        // ㅏ
//        if (x + 2 < n && y + 1 < m) {
//            int temp = arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y + 1];
//            result = Math.max(result, temp);
//        }
//        // ㅓ
//        if (x + 2 < n && y - 1 > 0) {
//            int temp = arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y - 1];
//            result = Math.max(result, temp);
//        }
//    }
}
