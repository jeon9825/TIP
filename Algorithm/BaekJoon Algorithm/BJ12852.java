import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ12852 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int dp[] = new int[1000001];
		int route[] = new int[1000001];

		dp[1] = 0;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + 1;
			route[i] = i - 1;
			if (i % 3 == 0) {
				int m = i / 3;
				if (dp[m] + 1 < dp[i]) {
					dp[i] = dp[m] + 1;
					route[i] = m;
				}
			}
			if (i % 2 == 0) {
				int m = i / 2;
				if (dp[m] + 1 < dp[i]) {
					dp[i] = dp[m] + 1;
					route[i] = m;
				}
			}
		}
		System.out.println(dp[N]);
		printRoute(route, N);
	}

	static void printRoute(int[] r, int N) {
		System.out.print(N + " ");
		if (N == 1)
			return;
		printRoute(r, r[N]);
	}
}
