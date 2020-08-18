import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] grape = new int[n];
		for (int i = 0; i < grape.length; i++) {
			grape[i] = Integer.parseInt(reader.readLine());
		}

		int[] dp = new int[n];

		dp[0] = grape[0];
		if (n == 1) {
			System.out.println(dp[0]);
			return;
		}
		dp[1] = grape[1] + grape[0];
		if (n == 2) {
			System.out.println(dp[1]);
			return;
		}

		dp[2] = Math.max(Math.max(grape[0] + grape[2], grape[0] + grape[1]), grape[1] + grape[2]);
		for (int i = 3; i < dp.length; i++) {
			dp[i] = Math.max(Math.max(dp[i - 3] + grape[i] + grape[i - 1], dp[i - 2] + grape[i]), dp[i - 1]);
		}

		System.out.println(dp[n - 1]);
	}
}
