package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		Deque<String> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String com = st.nextToken();
			
			if(com.equals("push")) {
				q.add(st.nextToken());
			}else if(com.equals("pop")) {
				if(q.isEmpty() == false) {
					System.out.println(q.pollFirst());
				}else {
					System.out.println(-1);
				}
			}else if(com.equals("size")) {
				System.out.println(q.size());
			}else if(com.equals("empty")) {
				if(q.isEmpty() == true) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(com.equals("front")) {
				if(q.isEmpty() == true) {
					System.out.println(-1);
				}else {
					System.out.println(q.peekFirst());
				}
			}else {
				if(q.isEmpty() == true) {
					System.out.println(-1);
				}else {
					System.out.println(q.peekLast());
				}
			}
		}
	}

}
