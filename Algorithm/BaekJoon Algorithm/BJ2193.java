import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] dp = new long[n];
		dp[0] = 1;
		if (n == 1) {
			System.out.println(dp[0]);
			return;
		}
		dp[1] = 1;
		if (n == 2) {
			System.out.println(dp[1]);
			return;
		}

		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n - 1]);
	}
}
