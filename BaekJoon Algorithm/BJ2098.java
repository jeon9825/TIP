import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2098 {
	static int n;
	static int[][] w;
	static int[][] dp;

	static int TSP(int curr, int visited) { // visited를 비트마스크로
		int min = dp[curr][visited];
		if (min != 0) // 이미 구한 적이 있음
			return min;

		if (visited == (1 << n) - 1) { // 모든 마을을 방문 했을 때 0번 마을로 다시 돌아간다.
			if (w[curr][0] != 0) { // 0번으로 다시 갈 수 있을 때
				return w[curr][0];
			} else {
				return 10000000; // 불가능
			}
		}

		min = 10000000; // 큰 수를 Integer.MAX_VALUE로 하면 왜 안되는지 모르겠음.
		int result = 0;
		for (int i = 0; i < n; i++) {
			if ((visited & 1 << i) != 0 || w[curr][i] == 0) // i번 마을을 방문했거나, 현재지점에서 i지점으로 가는 방법이 없을 때
				continue;

			result = TSP(i, (visited | 1 << i)) + w[curr][i]; // visited | 1 << i 는 i번 마을을 방문시킴
			if (result < min)
				min = result;
		}
		dp[curr][visited] = min;
		return min;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine()); // 도시 수
		w = new int[n][n];
		dp = new int[n][1 << n];
		StringTokenizer tokenizer;
		for (int i = 0; i < w.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < w[i].length; j++) {
				w[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		System.out.println(TSP(0, 1));
	}
}
