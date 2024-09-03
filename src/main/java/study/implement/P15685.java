package study.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15685 {

    static int[][] map = new int[101][101];
    static int[] chkdx = {0, 0, 1, 1};
    static int[] chkdy = {0, 1, 1, 0};

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            writeDragon(x, y, d, g);
        }

        int result = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (chk(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void writeDragon(int x, int y, int dir, int generation) {
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(dir);

        // 이전 세대의 방향을 역순으로 90도 회전시켜 추가
        for (int i = 0; i < generation; i++) {
            int size = directions.size();
            for (int j = size - 1; j >= 0; j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        map[x][y] = 1; // 시작점 방문 표시
        for (int d : directions) {
            x += dx[d];
            y += dy[d];
            map[x][y] = 1;
        }
    }

    static boolean chk(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            if (map[x + chkdx[i]][y + chkdy[i]] == 1) {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == 4) {
            return true;
        } else {
            return false;
        }
    }

}
