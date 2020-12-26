import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1495 {

	static int N;
	static int M;
	static int[] vol;
	static int[][] dp;

	static int solution(int index, int previous) {
		if (index == N)
			return previous;
		
		if (dp[index][previous] != Integer.MIN_VALUE)
			return dp[index][previous];
		int max = -1;
		if (previous + vol[index] <= M) {
			int val = solution(index + 1, previous + vol[index]);
			max = Math.max(max, val);
		}
		if (previous - vol[index] >= 0) {
			int val = solution(index + 1, previous - vol[index]);
			max = Math.max(max, val);
		}
		return dp[index][previous] = max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		int S = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		vol = new int[N];
		for (int i = 0; i < vol.length; i++) {
			vol[i] = Integer.parseInt(tokenizer.nextToken());
		}
		dp = new int[N][M + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		System.out.println(solution(0, S));
	}
}
