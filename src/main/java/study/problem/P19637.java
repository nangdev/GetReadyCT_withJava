package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<AKA> list = new ArrayList<AKA>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            list.add(new AKA(name, power));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int min = 0;
            int max = n;
            while (min <= max) {
                int mid = (min + max) / 2;

                if (list.get(mid).power < num) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }

            sb.append(list.get(min).name + "\n");
        }

        System.out.println(sb);

    }

    static class AKA implements Comparable<AKA> {
        String name;
        int power;

        public AKA(String name, int power) {
            this.name = name;
            this.power = power;
        }

        @Override
        public int compareTo(AKA o) {
            return this.power - o.power;
        }
    }
}
