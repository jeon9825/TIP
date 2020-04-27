import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2775 {
	public static int numberOfPeople(int a, int b) {
		int[][] apart = new int[a + 1][b];

		for (int i = 0; i < apart[0].length; i++) {
			apart[0][i] = i + 1;
		}
//		System.out.println(Arrays.deepToString(apart));
		for (int i = 1; i < apart.length; i++) {
			for (int j = 0; j < apart[i].length; j++) {
				for (int j2 = 0; j2 <= j; j2++) {
					apart[i][j] += apart[i - 1][j2];
				}

			}
		}
//		System.out.println(Arrays.deepToString(apart));
		return apart[a][b - 1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			int a = Integer.parseInt(reader.readLine());
			int b = Integer.parseInt(reader.readLine());
			System.out.println(numberOfPeople(a, b));
		}
	}
}
