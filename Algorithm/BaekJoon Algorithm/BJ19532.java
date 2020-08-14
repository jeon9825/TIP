import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19532 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		int d = Integer.parseInt(tokenizer.nextToken());
		int e = Integer.parseInt(tokenizer.nextToken());
		int f = Integer.parseInt(tokenizer.nextToken());

		int x = 0;
		int y = 0;
		for (int i = -999; i <= 999; i++) {
			for (int j = -999; j <= 999; j++) {
				if (a * i + b * j == c && d * i + e * j == f) {
					x = i;
					y = j;
					break;
				}
			}
		}
		System.out.println(x + " " + y);
	}
}
