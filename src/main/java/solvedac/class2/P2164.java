package solvedac.class2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		for (int i = 1; i < N; i++) {
			deque.pollFirst();
			deque.add(deque.pollFirst());
		}
		
		System.out.println(deque.pollFirst());
		
	}

}
