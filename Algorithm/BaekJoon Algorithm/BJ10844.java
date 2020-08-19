import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10844 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		final int MOD = 1000000000;
		int[][] dp = new int[n][9];

		for (int i = 0; i < 9; i++) {
			dp[0][i] = 1;

			if (n > 1) {
				if (i == 8) {
					dp[1][i] = 1;
				} else {
					dp[1][i] = 2;
				}
			}
		}

		if (n > 2) {
			for (int i = 2; i < dp.length; i++) { // 3행부터 즉, 3자리수부터 시작하는 이유는 맨 앞 1이 나올 경우, 2번째 전 행의 값을 활용하기 위해서
				for (int j = 0; j < dp[i].length; j++) {
					if (j == 0) {
						dp[i][j] = (dp[i - 2][j] + dp[i - 1][j + 1]) % MOD;
					} else if (j == 8) {
						dp[i][j] = (dp[i - 1][j - 1]) % MOD;
					} else {
						dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
					}
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += dp[n - 1][i];
			sum %= MOD;
		}
		System.out.println(sum);
	}
}
