import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15829 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int MOD = 1234567891;
		int n = Integer.parseInt(reader.readLine());
		char[] c = reader.readLine().toCharArray();
		int[] ci = new int[n];
		for (int i = 0; i < c.length; i++) {
			ci[i] = (c[i] - 96);
		}
		int sum = 0;
		int tmp = 1;
		for (int i = 0; i < ci.length; i++) {
			sum += (ci[i] * tmp) % MOD;
			sum %= MOD;
			tmp *= 31;
			tmp %= MOD;
		}
		System.out.println(sum % MOD);
	}
}
