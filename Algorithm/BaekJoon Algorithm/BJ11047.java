import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(reader.readLine());
		}
		int money = 0;
		int cnt = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] <= k) {
				while (money + a[i] <= k) {
					money += a[i];
					cnt++;
				}
			} else
				continue;
		}
		System.out.println(cnt);
	}
}
