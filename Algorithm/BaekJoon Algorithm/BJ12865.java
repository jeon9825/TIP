import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());

		int[][] dp = new int[n + 1][k + 1];

		int[] w = new int[n + 1];
		int[] v = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			w[i] = Integer.parseInt(tokenizer.nextToken());
			v[i] = Integer.parseInt(tokenizer.nextToken());

		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - w[i] >= 0) { // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]); // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의
																					// 가치중 큰 값을 정해 더한다.
				}
			}
		}

		System.out.println(dp[n][k]);

	}
}
