package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 이거 맵으로 처리하면 될거같은데
        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> dic = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	String s = st.nextToken();
        	if(dic.get(s) == null) {
        		dic.put(s, 1);
        	}else {
        		dic.put(s,dic.get(s)+1);
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M-1; i++) {
        	String s = st.nextToken();
            if(dic.get(s) != null) {
            	sb.append(dic.get(s)+" ");
            }else {
            	sb.append(0+" ");
            }
            	
        }
        
    	String s = st.nextToken();
        if(dic.get(s) != null) {
        	sb.append(dic.get(s));
        }else {
        	sb.append(0);
        }
        
        System.out.println(sb);

    }

}
