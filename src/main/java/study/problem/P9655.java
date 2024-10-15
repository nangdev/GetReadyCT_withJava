package study.problem;

import java.util.Scanner;

public class P9655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		boolean flag = true;

		while (true) {
			if (n - 3 >= 0) {
				n -= 3;
			} else {
				n--;
			}

			if (n == 0) {
				break;
			}

			if (flag) {
				flag = false;
			} else {
				flag = true;
			}
		}

		if (flag) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

}
