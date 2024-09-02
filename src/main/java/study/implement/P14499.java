package study.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] command = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        int[] dice = new int[7];

        for (int i : command) {
            int com = i - 1;

            if (0 <= x + dx[com] && x + dx[com] < n && y + dy[com] >= 0 && y + dy[com] < m) {
                x += dx[com];
                y += dy[com];
            } else {
                continue;
            }

            if (com == 0) {  //동
                int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
            } else if (com == 1) { //서
                int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
            } else if (com == 2) { //북
                int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
            } else if (com == 3) { //남
                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
            }
            if (map[x][y] == 0) {
                map[x][y] = dice[6];
            } else {
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            sb.append(dice[1] + "\n");
        }
        System.out.println(sb);
    }
}
