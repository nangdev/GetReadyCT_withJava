package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Dir{
    int x;
    int y;

    public Dir(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class P11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        List<Dir> lis = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lis.add(new Dir(x,y));
        }

        Collections.sort(lis, ((o1, o2) -> {
            return o1.x == o2.x ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x,o2.x);
        }));

        for (Dir li : lis) {
            System.out.println(li.x+ " " + li.y);
        }
    }
}
