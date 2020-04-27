import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int order = -1;
		for (int i = 0; i < 9; i++) {
			int N = Integer.parseInt(reader.readLine());
			if (max < N) {
				max = N;
				order = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(order);
	}
}
