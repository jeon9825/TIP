import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010 {
	static int combination(int n, int r) {
		if (r == 1)
			return n;
		if (n == r || r == 0)
			return 1;
		return combination(n - 1, r) + combination(n - 1, r - 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 연산의 개수
		StringTokenizer tokenizer;
		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int r = Integer.parseInt(tokenizer.nextToken());
			int n = Integer.parseInt(tokenizer.nextToken());

			System.out.println(combination(n, r));
		}
	}
}
