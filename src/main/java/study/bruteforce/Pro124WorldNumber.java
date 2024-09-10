package study.bruteforce;

import java.util.Scanner;

public class Pro124WorldNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		int temp = n;

		while (temp > 0) {
			if (temp % 3 == 0) {
				temp = temp / 3 - 1;
				sb.append(4);

			} else {
				sb.append(temp % 3);
				temp /= 3;
			}
		}

		sb.reverse();

		return sb.toString();
	}

}
