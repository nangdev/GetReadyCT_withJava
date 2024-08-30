import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prac {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = { { 1, 2, 3 }, { 1, 5, 6 } };

		int[][] game = new int[2][3];

		for (int i = 0; i < 2; i++) {
			game[i] = arr[i].clone();
		}

		game[0][0] = 1000;

		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(game[1]));
	}
}
