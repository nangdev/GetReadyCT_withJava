package solvedac.class2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ssafy\\GetReadyCT_withJava\\src\\main\\java\\solvedac\\class2\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n ; i++) {
			
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		long[] lis = new long[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m ; i++) {
			
			lis[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < m; i++) {
			int result = Arrays.binarySearch(arr, lis[i]);
			
			if(result >=0) {
				System.out.println(1);
			}
			else {
				System.out.println(0);

			}
		}
		
		
	}

}
