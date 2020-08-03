import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {
	static int[][] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(reader.readLine());
			if (num == 0) {
				System.out.println(1 + " " + 0);
			} else if (num == 1) {
				System.out.println(0 + " " + 1);
			} else {
				count = new int[2][num + 1];
				count[0][0] = 1;
				count[1][1] = 1;

				for (int j = 2; j <= num; j++) {
					count[0][j] = count[0][j - 1] + count[0][j - 2];
					count[1][j] = count[1][j - 1] + count[1][j - 2];
				}
				System.out.println(count[0][num] + " " + count[1][num]);
			}
		}
	}
}
