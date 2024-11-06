import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prac {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] cs = {'a', 'b', 'c'};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("9");
        }
        System.out.println(sb);
    }
}
