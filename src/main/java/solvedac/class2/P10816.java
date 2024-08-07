package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10816 {

	public static void main(String[] argsg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 이거 맵으로 처리하면 될거같은데
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] lis = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			lis[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[M];
		
		for (int i = 0; i < M; i++) {
			
		}
		
		System.out.println(Arrays.toString(result));
		
	}

}
