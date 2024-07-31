package solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // BigInteger를 사용하여 큰 숫자를 저장
        BigInteger bigNumber = new BigInteger(br.readLine());

        // 숫자를 문자열로 변환한 뒤 각 자리 수의 합 계산
        String numberStr = bigNumber.toString();
        int sum = 0;
        for (char c : numberStr.toCharArray()) {
            sum += c - '0';
        }

        System.out.println(sum);
    }
}
