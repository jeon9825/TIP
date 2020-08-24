import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11055 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int[] dp = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++)
				if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i])
					dp[i] = dp[j] + arr[i];
			if (max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
