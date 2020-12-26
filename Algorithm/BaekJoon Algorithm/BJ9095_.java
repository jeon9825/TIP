import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095_ {

	static int[] dp;

	static int solution(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		if (dp[n] != 0)
			return dp[n];
		return dp[n] = solution(n - 1) + solution(n - 2) + solution(n - 3);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			dp = new int[n + 1];
			System.out.println(solution(n));
		}
	}
}
