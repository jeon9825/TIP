import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ4150 {
	static BigInteger fib(int n) {
		BigInteger a = BigInteger.valueOf(1);
		BigInteger b = BigInteger.valueOf(1);
		if (n == 1 || n == 2) {
			return a;
		}
		BigInteger c = null;
		for (int i = 2; i < n; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		System.out.println(fib(n));
	}
}
