import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int[] dp = new int[n + 1];
		for (int i = 1; i < dp.length; i++) {
			int d = (int) Math.pow(i, 2);
			if (d < dp.length)
				dp[d] = 1;
			else
				break;
		}
		for (int i = 2; i < dp.length; i++) {
			if (dp[i] != 1)
				dp[i] = dp[i - 1] + 1;
			for (int j = 2; j < i; j++) {
				int s = dp[i - j] + dp[j];
				dp[i] = Math.min(dp[i], s);
			}
		}
		System.out.println(dp[n]);
	}
}
