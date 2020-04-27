import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14647 {
	static int count9(int k) {
		int cnt = 0;
		while (true) {
			int r = k % 10;
			if (r == 9)
				cnt++;
			k /= 10;
			if (k == 0)
				break;
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[][] bingo = new int[n][m];
		for (int i = 0; i < bingo.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < bingo[i].length; j++) {
				int k = Integer.parseInt(tokenizer.nextToken());
				bingo[i][j] = count9(k);
			}
		}
		int ans = Integer.MIN_VALUE;
		int r = -1;
		int c = -1;
		for (int i = 0; i < bingo.length; i++) {
			int sum = 0;
			for (int j = 0; j < bingo[i].length; j++) {
				sum += bingo[i][j];
			}
			if (ans < sum) {
				ans = sum;
				r = i;
			}
		}
		boolean b = true;
		for (int i = 0; i < bingo[0].length; i++) {
			int sum = 0;
			for (int j = 0; j < bingo.length; j++) {
				sum += bingo[j][i];
			}
			if (ans < sum) {
				b = false;
				ans = sum;
				c = i;
			}
		}
		
		int result=0;
		if (b) {
			for (int i = 0; i < bingo[r].length; i++) {
				bingo[r][i] = 0;
			}
			for (int i = 0; i < bingo.length; i++) {
				for (int j = 0; j < bingo[i].length; j++) {
					result += bingo[i][j];
				}
			}
		} else {
			for (int i = 0; i < bingo.length; i++) {
				bingo[i][c] = 0;
			}
			for (int i = 0; i < bingo.length; i++) {
				for (int j = 0; j < bingo[i].length; j++) {
					result += bingo[i][j];
				}
			}
		}
		System.out.println(result);
	}
}
