import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP[n] = DP[n-2] * 3 + sum(DP[n-i]*2) + 2*3 + 2
public class BJ2133 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int[] dp = new int[n + 1];
		dp[0] = 1;
		if (n == 1) {
			System.out.println(0);
			return;
		}

		dp[2] = 3;
		for (int i = 4; i < dp.length; i++) {
			if (i % 2 == 0) {
				dp[i] += dp[i - 2] * 3;
				for (int j = 1; j < i - 2; j++) {
					dp[i] += dp[j] * 2;
				}
				dp[i] += 2;
			}
		}

		System.out.println(dp[n]);
	}
}
