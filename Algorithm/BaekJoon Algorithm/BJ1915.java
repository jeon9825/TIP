import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1915 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		int[][] arr = new int[n][m];
		int[][] d = new int[n][m];

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			String s = reader.readLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.charAt(j) - '0';
				if (arr[i][j] == 1) {
					d[i][j] = 1;
					ans = 1;
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i - 1][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i][j - 1] == 1) {
					d[i][j] = Math.min(Math.min(d[i - 1][j], d[i - 1][j - 1]), d[i][j - 1]) + 1;
				}
				ans = Math.max(d[i][j], ans);
			}
		}
		System.out.println(ans * ans);
	}

}
