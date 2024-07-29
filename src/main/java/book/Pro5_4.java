package book;

import java.util.*;

public class Pro5_4 {
    public static void main(String[] args) {
        int[] a = {4,2,2,1,3,4};
        System.out.println(Arrays.toString(solution(a)));
    }

    public static int[] solution(int[] arr){
        Integer[] res = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        Arrays.sort(res, Collections.reverseOrder());

        return Arrays.stream(res).mapToInt(Integer::intValue).toArray();
    }
}
