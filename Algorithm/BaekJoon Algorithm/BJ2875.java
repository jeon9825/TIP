import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2875 {
	static int m;
	static int n;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		m = Integer.parseInt(tokenizer.nextToken());
		n = Integer.parseInt(tokenizer.nextToken());
		k = Integer.parseInt(tokenizer.nextToken());

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= k; i++) {
			if (m < i) {
				break;
			}

			int m1 = m - i;
			int n1 = n - (k - i);

			if (m1 >= n1 * 2) {
				max = Math.max(n1, max);
			} else {
				max = Math.max(m1 / 2, max);
			}
		}

		System.out.println(max);
	}
}
