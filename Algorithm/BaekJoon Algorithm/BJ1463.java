import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int dp[] = new int[1000001];

		dp[1] = 0;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				int m = i / 3;
				dp[i] = Math.min(dp[i], dp[m] + 1);
			}
			if (i % 2 == 0) {
				int m = i / 2;
				dp[i] = Math.min(dp[i], dp[m] + 1);
			}
		}
		System.out.println(dp[N]);
	}

}
