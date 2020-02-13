import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11050 {
	static int[] f = new int[11];

	static int factorial(int n) {
		if (f[n] != 0) {
			return f[n];
		}
		if (n <= 1) {
			return f[n] = 1;
		}
		return f[n] = factorial(n - 1) * n;
	}

	public static int nCr(int n, int r) {
		int C = factorial(n) / (factorial(n - r) * factorial(r));
		return C;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());

		System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
	}

}
