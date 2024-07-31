package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            String ans = sol(arr);
            if(ans.equals("end")){
                break;
            }
            else{
                System.out.println(ans);
            }
        }
    }


    public static String sol(int[] nums){
        Arrays.sort(nums);
        int a = nums[0],b = nums[1],c = nums[2];

        if(c*c == 0){
            return "end";
        }
        else if(c*c == a*a + b*b){
            return "right";
        }
        else{
            return "wrong";
        }
    }
}
