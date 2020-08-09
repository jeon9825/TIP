import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11726 {
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		dp = new int[n + 1];
		dp(n);
		System.out.println(dp[n]);
	}

	static void dp(int n) {
		dp[1] = 1;
		if (n == 1)
			return;
		dp[2] = 2;
		if (n == 2)
			return;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
	}
}
