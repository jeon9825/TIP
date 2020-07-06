import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11660 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		int[][] pSum = new int[N + 1][N + 1];

		for (int i = 1; i < pSum.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 1; j < pSum[i].length; j++) {
				int n = Integer.parseInt(tokenizer.nextToken());
				pSum[i][j] = pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1] + n;
			}
		}

		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int y1 = Integer.parseInt(tokenizer.nextToken());
			int x1 = Integer.parseInt(tokenizer.nextToken());
			int y2 = Integer.parseInt(tokenizer.nextToken());
			int x2 = Integer.parseInt(tokenizer.nextToken());

			System.out.println(pSum[y2][x2] - pSum[y2][x1 - 1] - pSum[y1 - 1][x2] + pSum[y1 - 1][x1 - 1]);
		}
	}
}
