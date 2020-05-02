import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ9613 {
	static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	static int gcd(int a, int b) {
		if (a == 1 || b == 1)
			return 1;
		int r = a % b;
		if (r == 0)
			return b;
		return gcd(b, r);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int[] num = new int[n];
			for (int j = 0; j < n; j++) {
				num[j] = Integer.parseInt(tokenizer.nextToken());
			}
			int A;
			int B;
			long sum = 0;
			for (int j = 0; j < num.length; j++) {
				A = num[j];
				for (int j2 = j + 1; j2 < num.length; j2++) {
					B = num[j2];
					sum += gcd(A, B);
				}
			}
			System.out.println(sum);
		}
	}
}
