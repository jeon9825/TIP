import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ9465 {
	static int[][] dp;

	// 파라미터로 주어진 열에서 끝 열까지 점수 합계
	static int sum(int[][] a, int index, int previous) {
		if (index >= a[0].length)
			return 0; // 종료조건
		if (dp[index][previous] != -1)
			return dp[index][previous];
		int max = 0;
		for (int r = 0; r <= 2; r++) {
			if (r == 0 || r != previous) {
				int ans = a[r][index] + sum(a, index + 1, r);
				if (ans > max)
					max = ans;
			}
		}
		return dp[index][previous] = max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			int[][] a = new int[3][n];

			StringTokenizer tokenizer;
			for (int j = 1; j <= 2; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				for (int j2 = 0; j2 < a[j].length; j2++) {
					a[j][j2] = Integer.parseInt(tokenizer.nextToken());
				}
			}
			dp = new int[n][3];
			for (int j = 0; j < dp.length; j++) {
				for (int j2 = 0; j2 < dp[j].length; j2++) {
					dp[j][j2] = -1;
				}
			}
			System.out.println(sum(a, 0, 0));
		}
	}
}
