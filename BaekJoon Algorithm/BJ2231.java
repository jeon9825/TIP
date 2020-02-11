import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {
	public static int sum(int n) {
		int sum = n;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static int decomposition(int N) {
		for (int i = 0; i < N; i++) {
			if (sum(i) == N)
				return i;
		}
		return 0;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		int con = decomposition(N);
		System.out.println(con);
	}
}
