import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1309_ {
	static int N;
	static int[][] dp;
	static int MOD = 9901;

	static int solution(int index, int previous) {
		if (index == N)
			return 1;
		if (dp[index][previous] != 0)
			return dp[index][previous];
		int count = 0;
		count += solution(index + 1, 0) % MOD;
		if (previous != 1)
			count += solution(index + 1, 2) % MOD;
		if (previous != 2)
			count += solution(index + 1, 1) % MOD;
		return dp[index][previous] = count % MOD;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		dp = new int[N][3];
		System.out.println(solution(0, 0));
	}
}
