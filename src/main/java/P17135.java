import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17135 {
    static int n,m,d,result = 0, killidx = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m];

        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            kill();

            nextGame();
        }

        System.out.println(result);

    }

    static void nextGame(){
        for (int i = 0; i < n-1; i++) {
            arr[i+1] = arr[i].clone();
        }

        for (int i = 0; i < m; i++) {
            arr[0][m] = 0;  // 첫번째 행 초기화 하나씩 밀었으니
            arr[n][m] = 0;  // 마지막 행 초기화 성 있는 곳
        }

        killidx++;
    }

    static void kill(){
        int a,b,c;

        for (int i = 0; i < m-2; i++) {
            for (int j = i+1; j < m-1; j++) {
                for (int k = j+1; k < m; k++) {
                    a = i;
                    b = j;
                    c = k;

                    for (int l = n-1; l > killidx; l--) {
                        for (int o = 0; o < m; o++) {
                            if(arr[l][o] == 1){
                                int distance = Math.abs(n-l) + Math.abs(a-o);
                                if(distance <= d){
                                    result++;
                                    arr[l][o] = 0;
                                }
                            }
                        }
                    }

                    for (int l = n-1; l > killidx; l--) {
                        for (int o = 0; o < m; o++) {
                            if(arr[l][o] == 1){
                                int distance = Math.abs(n-l) + Math.abs(b-o);
                                if(distance <= d){
                                    result++;
                                    arr[l][o] = 0;
                                }
                            }
                        }
                    }

                    for (int l = n-1; l > killidx; l--) {
                        for (int o = 0; o < m; o++) {
                            if(arr[l][o] == 1){
                                int distance = Math.abs(n-l) + Math.abs(c-o);
                                if(distance <= d){
                                    result++;
                                    arr[l][o] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
