import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ13171 {

	static long power(long a, long x) {
		String s = Long.toBinaryString(x);

		long[] dp = new long[s.length() + 1];
		dp[1] = a % 1000000007;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = ((dp[i - 1] * dp[i - 1]) % 1000000007);
		}
		long ans = 1;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0') {
				ans *= ((dp[s.length() - i]) % 1000000007);
				ans %= 1000000007;
			}
		}
		return ans;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(reader.readLine());
		long x = Long.parseLong(reader.readLine());
		System.out.println(power(a, x));
	}
}
