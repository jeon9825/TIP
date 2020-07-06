import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1024 {
	static void sum(int N, int L) {
		for (int i = L; i <= 100; i++) {
			int tmp = N - (i * (i + 1) / 2);

			if (tmp % i == 0) {
				int x = tmp / i + 1;
				if (x >= 0) { //TODO: 왜 0보다 크거나 같을 때를 비교하는지 모르겠음...
					for (int j = 0; j < i; j++) {
						System.out.print(x + j + " ");
					}
					return;
				}
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(tokenizer.nextToken());
		int L = Integer.parseInt(tokenizer.nextToken());

		sum(N, L);
	}
}
