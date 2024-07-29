package book;

import java.lang.reflect.Array;
import java.util.*;

public class P5_5 {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,1};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] numbers){
        Set<Integer> lis = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i==j){
                    continue;
                }
                lis.add(numbers[i] + numbers[j]);
            }
        }

        return lis.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
