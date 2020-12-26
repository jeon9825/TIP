import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1351 {

	static long N;
	static long P;
	static long Q;

	static long[] dp = new long[10000000];

	static long solution(long i) {
		if (i < dp.length) {
			int index = (int) i;
			if (dp[index] != 0)
				return dp[index];
			return dp[index] = solution(index / P) + solution(index / Q);
		}
		return solution(i / P) + solution(i / Q);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		N = Long.parseLong(tokenizer.nextToken());
		P = Long.parseLong(tokenizer.nextToken());
		Q = Long.parseLong(tokenizer.nextToken());
		dp[0] = 1;
		System.out.println(solution(N));
	}
}
