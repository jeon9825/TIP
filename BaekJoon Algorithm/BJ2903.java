import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2903 {

	public static double countDot(int n) {
		int count = 2;
		for (int i = 0; i < n; i++) {
			count = count * 2 - 1;
		}
		return Math.pow(count, 2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		System.out.println((int) countDot(N));
	}

}
