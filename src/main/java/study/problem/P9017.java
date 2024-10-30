package study.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()) + 1;
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();

            int[] arr = new int[n];
            for (int j = 1; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[j] = val;

                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
            }

            List<Integer> keys = new ArrayList<>();

            for (Integer key : map.keySet()) {
                if (map.get(key) != 6) {
                    keys.add(key);
                }
            }

            for (Integer key : keys) {
                map.remove(key);
            }

            //새로운 배열 만들어서 그값을 섬에다가 더해야함
            int[] temp = new int[n];
            int idx = 1;
            for (int j = 1; j < n; j++) {
                if (map.containsKey(arr[j])) {
                    temp[j] = idx;
                    idx++;
                } else {
                    temp[j] = 0;
                }
            }

            for (Integer key : map.keySet()) {
                int sum = 0;
                int cnt = 0;
                for (int j = 1; j < n; j++) {
                    if (arr[j] == key) {
                        sum += temp[j];
                        cnt++;
                    }
                    if (cnt == 4) {
                        break;
                    }
                }
                map.put(key, sum);
            }

            int minval = Integer.MAX_VALUE;
            int result = 0;
            int cnt = 0;
            for (Integer key : map.keySet()) {
                if (map.get(key) <= minval) {
                    minval = map.get(key);
                    result = key;
                    cnt++;
                }
            }

            if (cnt == 1) {
                sb.append(result + "\n");
                continue;
            }

            int finalval = Integer.MAX_VALUE;
            for (Integer key : map.keySet()) {
                if (map.get(key) == minval) {
                    int idxcnt = 0;
                    for (int j = 1; j < n; j++) {
                        if (arr[j] == key) {
                            idxcnt++;
                        }

                        if (idxcnt == 5) {
                            if (finalval > j) {
                                finalval = j;
                                result = key;
                            }
                        }

                    }
                }
            }

            sb.append(result + "\n");
        }
        System.out.println(sb);

    }


}

