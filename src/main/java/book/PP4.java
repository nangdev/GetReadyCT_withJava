package book;

import java.util.*;

public class PP4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(arr)));

        List<Integer> lis = new ArrayList<>();
        lis.add(1);
        lis.add(100);
        lis.add(200);
        lis.add(3000);
        lis.add(5);

        System.out.println(lis.stream().max(Integer::compareTo).orElse(-1));
    }
    
    public static int[] solution(int[] ans){
        int[][] pattern = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] scores = new int[3];

        for (int i = 0; i <ans.length ; i++) {
            for (int j = 0; j <pattern.length ; j++) {
                if(ans[i] == pattern[j][i%pattern[j].length]){
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(scores[i]==maxScore){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
