import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501 {
	static int ans = 0;

	static void go(int[] t, int[] p, int n, int index, int sum) {
		if (n == index) {
			if (ans < sum)
				ans = sum;
			return;
		}

		if (n < index) {
			return;
		}

		go(t, p, n, index + t[index], sum + p[index]);
		go(t, p, n, index + 1, sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			T[i] = Integer.parseInt(tokenizer.nextToken());
			P[i] = Integer.parseInt(tokenizer.nextToken());
		}

		go(T, P, N, 0, 0);
		System.out.println(ans);
	}
}
