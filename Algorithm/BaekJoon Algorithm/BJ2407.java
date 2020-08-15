import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ2407 {
	static BigInteger[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		dp = new BigInteger[n + 1][m + 1];
		System.out.println(nCm(n, m));
	}

	static BigInteger nCm(int n, int m) {
		if (n == m || m == 0)
			return BigInteger.ONE;
		if (dp[n][m] != null)
			return dp[n][m];

		dp[n][m] = new BigInteger("0");
		return dp[n][m] = dp[n][m].add(nCm(n - 1, m - 1)).add(nCm(n - 1, m));
	}
}
