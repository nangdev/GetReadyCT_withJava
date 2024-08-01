package solvedac.class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            lis.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(lis);

        for (Integer li : lis) {
            bw.write(li + "\n");
        }

        bw.flush();
    }
}
