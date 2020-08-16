import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp[n] = dp[n-1]*2 + dp[n-2]
// dp[1] = 3 dp[2] = 7 dp[3] = 17 dp[4] = 41
public class BJ1309 {
	static int N;
	static int DP[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		int[][] DP = new int[N + 1][3];

		DP[1][0] = 1;
		DP[1][1] = 1;
		DP[1][2] = 1;

		for (int i = 2; i <= N; i++) {
			DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) % 9901; // 없을때
			DP[i][1] = (DP[i - 1][0] + DP[i - 1][2]) % 9901; // 왼쪽에 있을 때
			DP[i][2] = (DP[i - 1][0] + DP[i - 1][1]) % 9901; // 오른쪽에 있을때
		}
		System.out.println((DP[N][0] + DP[N][1] + DP[N][2]) % 9901);
	}

}
