import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11057 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		final int MOD = 10007;
		int n = Integer.parseInt(tokenizer.nextToken());
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 8; j >= 0; j--) {
				arr[j] += arr[j + 1];
				arr[j] %= MOD;
			}
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans += arr[i];
			ans %= MOD;
		}
		System.out.println(ans);
	}
}
