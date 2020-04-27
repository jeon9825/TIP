import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1834 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int sum = 0;
		for (int i = 1; i < n; i++) {
			sum += i * (n + 1);
		}
		System.out.println(sum);
	}
}
