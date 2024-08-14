import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prac {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> arr = new ArrayList<>();

		for (int j = 0; j < 3; j++) {
			arr.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toList());
		}

		for (int i = 0; i < 3; i++) {
			for (Integer idx : arr.get(i)) {
				System.out.print(idx + " ");
			}
			System.out.println();
		}
	}
}
