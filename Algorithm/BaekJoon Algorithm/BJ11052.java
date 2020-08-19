import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11052 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] p = new int[n + 1];
		for (int i = 1; i < p.length; i++) {
			p[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int[] dp = new int[n + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(p[j] + dp[i - j], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
