import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5585 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = 1000 - Integer.parseInt(reader.readLine());
		int c500 = n / 500;
		n -= c500 * 500;
		int c100 = n / 100;
		n -= c100 * 100;
		int c50 = n / 50;
		n -= c50 * 50;
		int c10 = n / 10;
		n -= c10 * 10;
		int c5 = n / 5;
		n -= c5 * 5;
		int c1 = n;

		System.out.println(c500 + c100 + c50 + c10 + c5 + c1);
	}
}
