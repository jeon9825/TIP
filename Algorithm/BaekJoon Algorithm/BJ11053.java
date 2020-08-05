import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
			dp[i] = 1;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j] && dp[i] >= dp[j])
					dp[j] = dp[i] + 1;
			}
		}
		int max = -1;
		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
