package solvedac.class2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class P1259 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\CTReady_withJava\\src\\main\\java\\solvedac\\class1\\input.txt"));
        Scanner sc = new Scanner(System.in);

        while(true){
            int pal = sc.nextInt();
            if(pal == 0){
                break;
            }

            int[] arr = Stream.of(String.valueOf(pal).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n = arr.length;
            boolean chk = true;
            for (int i = 0; i < n/2; i++) {
                if(arr[i] != arr[n-i-1]){
                    chk = false;
                    break;
                }
            }

            if(chk){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }

    }
}
