import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1629 {
	static long power(long a, long b, long c) {
		if (b == 0)
			return 1;
		else {
			long tmp = power(a, b / 2, c) % c;
			if (b % 2 == 0) {
				return (tmp * tmp) % c;
			} else {
				return ((tmp * tmp) % c * a % c) % c;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		System.out.println(power(a, b, c));
	}
}
