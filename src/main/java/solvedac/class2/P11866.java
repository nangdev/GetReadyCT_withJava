package solvedac.class2;

import java.util.*;

public class P11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        List<Integer> result = new ArrayList<>();

        while(!deque.isEmpty()){
            for (int i = 0; i < K-1; i++) {
                int front = deque.pollFirst();
                deque.add(front);
            }
            result.add(deque.pollFirst());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-1; i++) {
            sb.append(result.get(i) + ", ");
        }
        sb.append(result.get(N-1));

        System.out.println("<"+sb+">");
    }
}
