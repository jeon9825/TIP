import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14490 {
	static int g(int n, int m) {
		int r = n % m;
		if (r == 0)
			return m;
		else
			return g(m, r);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), ":");
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int gcd = g(n, m);
		n /= gcd;
		m /= gcd;
		System.out.println(n + ":" + m);
	}
}
