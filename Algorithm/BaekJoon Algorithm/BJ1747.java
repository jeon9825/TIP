import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ1747 {
	static final int MAX = 2000000;

	static List<Integer> getPrimeNumbers(int min) {
		boolean[] prime = new boolean[MAX + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; (i * i) <= MAX; i++) {
			if (prime[i]) {
				for (int j = i * 2; j <= MAX; j += i) {
					prime[j] = false;
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = min; i <= MAX; i++) {
			if (prime[i])
				result.add(i);
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int min = Integer.parseInt(reader.readLine());
		List<Integer> primes = getPrimeNumbers(min);

		for (int num : primes) {
			String snumber = String.valueOf(num);
			StringBuilder sb = new StringBuilder(snumber);
			if (snumber.equals(sb.reverse().toString())) {
				System.out.println(num);
				break;
			}
		}
	}
}
