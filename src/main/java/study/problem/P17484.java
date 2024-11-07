package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;
        int[] dy = {-1, 0, 1};
        ArrayDeque<Point> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {

            q.add(new Point(0, i, arr[0][i], 4));

            while (!q.isEmpty()) {
                Point p = q.pollFirst();

                if (p.x == n - 1) {
                    result = Math.min(result, p.val);
                    continue;
                }

                for (int j = 0; j < 3; j++) {
                    int nx = p.x + 1;
                    int ny = p.y + dy[j];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if (p.direc != j) {
                        q.add(new Point(nx, ny, p.val + arr[nx][ny], j));
                    }
                }
            }
        }

        System.out.println(result);
    }

    static class Point {
        int x, y, val, direc;

        public Point(int x, int y, int val, int direc) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.direc = direc;
        }
    }
}
