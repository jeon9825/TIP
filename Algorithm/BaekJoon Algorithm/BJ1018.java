import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		char[][] chess = new char[n][m];
		for (int i = 0; i < chess.length; i++) {
			String s = reader.readLine();
			for (int j = 0; j < chess[i].length; j++) {
				chess[i][j] = s.charAt(j);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < chess.length - 7; i++) {
			for (int j = 0; j < chess[i].length - 7; j++) {
				int count = 0;
				for (int i2 = i; i2 < i + 8; i2++) {
					for (int j2 = j; j2 < j + 8; j2++) {
						char ch = (i2 + j2) % 2 == 0 ? 'B' : 'W';
						if (chess[i2][j2] == ch)
							count++;
					}
				}
				count = Math.min(count, 64 - count);
				min = Math.min(min, count);
			}
		}
		System.out.println(min);
	}
}
