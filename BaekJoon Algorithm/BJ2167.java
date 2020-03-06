import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2167 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		int t = Integer.parseInt(reader.readLine());
		for (int k = 0; k < t; k++) {
			int sum = 0;
			tokenizer = new StringTokenizer(reader.readLine());
			int i = Integer.parseInt(tokenizer.nextToken());
			int j = Integer.parseInt(tokenizer.nextToken());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			for (int l = i - 1; l < x; l++) {
				for (int o = j - 1; o < y; o++) {
					sum += arr[l][o];
				}
			}
			System.out.println(sum);
		}
	}
}
