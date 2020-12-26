import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11057_ {

	static int N;
	static int[][] dp;
	static int MOD = 10007;
	
	static int solution(int index, int previous) {
		if (N == index)
			return 1;
		if (dp[index][previous] != 0)
			return dp[index][previous];
		
		int count = 0;
		for (int i = previous; i <= 9; i++) {
			count += solution(index + 1, i) % 10007;
		}
		return dp[index][previous] = count % 10007;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		dp = new int[N][10];
		System.out.println(solution(0, 0));
	}
}
