package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> lis = new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            lis.add(br.readLine());
        }

        String[] arr = lis.stream()
                .distinct()
                .sorted((s1, s2) -> {
                    int lenDiff = s1.length() - s2.length();
                    return lenDiff != 0 ? lenDiff : s1.compareTo(s2);
                })
                .toArray(String[]::new);

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
