package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.length() < m) {
                continue;
            }

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqCompare = map.get(b) - map.get(a); // 1. 빈도 비교 (내림차순)
            if (freqCompare == 0) {
                int lengthCompare = b.length() - a.length(); // 2. 길이 비교 (내림차순)
                if (lengthCompare == 0) {
                    return a.compareTo(b); // 3. 알파벳 순 비교 (오름차순)
                }
                return lengthCompare;
            }
            return freqCompare;
        });

        pq.addAll(map.keySet());

        while (!pq.isEmpty()) {
            sb.append(pq.poll() + "\n");
        }

        System.out.println(sb);
    }
}
