import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2588 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int[] b = new int[3];
		String s = reader.readLine();
		for (int i = 0; i < b.length; i++) {
			b[i] = s.charAt(2 - i) - '0';
		}

		int ans = 0;
		for (int i = 0; i < b.length; i++) {
			int n = a * b[i];
			System.out.println(n);
			ans += n * Math.pow(10, i);
		}
		System.out.println(ans);
	}
}
