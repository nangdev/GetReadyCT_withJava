package study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
 
        long num1 = arr[0];
        long num2 = arr[n-1];
        
        for (int i = 0; i < n; i++) {
			long temp1 = arr[i];
			long temp2 = 0;
			
			int min = 0;
			int max = n;
			
			long add = arr[n-2]+num2;
			
			while (min < max) {
				int mid = (min+max)/2;
				
				long val = Math.abs(arr[mid]+temp1);
				
				if(val < add) {
					min = mid+1;
					add = val;
				}else{
					max = mid;
				}
			}
			temp2 = arr[min-1];
        	
        	if(Math.abs(num1+num2) > Math.abs(temp1+temp2)) {
        		num1 = temp1;
        		num2 = temp2;
        	}
		}
        
        System.out.println(num1 +" "+num2);
       
    }
}
