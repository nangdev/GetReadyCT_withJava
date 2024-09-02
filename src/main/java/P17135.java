import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P17135 {
    static int n, m, d, result = 0, killidx = 0;
    static int[][] arr;
    static int[][] game;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        game = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    newMap();
                    result = 0;
                    for (int l = 0; l < n; l++) {
                        kill(i, j, k);

                        nextTurn();
                    }
                    answer = Math.max(answer, result);
                }
            }
        }

        System.out.println(answer);

    }

    static void newMap() {
        for (int i = 0; i < n; i++) {
            game[i] = arr[i].clone();
        }
    }

    static void nextTurn() {
        for (int i = n - 1; i > 0; i--) {
            game[i] = game[i - 1].clone();
        }

        for (int i = 0; i < m; i++) {
            game[0][i] = 0;
        }

    }

    static void kill(int a, int b, int c) {
        boolean flag = false;
        int[] archer = {a, b, c};
        Set<int[]> enemy = new HashSet<>();

        for (int archeridx = 0; archeridx < 3; archeridx++) {
            int tarX = -1;
            int tarY = -1;
            int minDis = Integer.MAX_VALUE;
            for (int l = n - 1; l > 0; l--) {
                for (int o = 0; o < m; o++) {
                    if (game[l][o] == 1) {
                        int distance = Math.abs(n - l) + Math.abs(archer[archeridx] - o);
                        if (distance <= d) {
                            if (distance < minDis || (distance == minDis && o < tarY)) {
                                minDis = distance;
                                tarX = l;
                                tarY = o;
                            }
                        }
                    }
                }
            }
            if (tarX != -1) {
                enemy.add(new int[]{tarX, tarY});
            }
        }

        for (int[] e : enemy) {
            if (game[e[0]][e[1]] == 1) {
                result++;
                game[e[0]][e[1]] = 0;
            }
        }

    }
}
