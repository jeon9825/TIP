import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10162 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		int a = 0;
		int b = 0;
		int c = 0;

		if (t % 10 != 0) {
			System.out.println(-1);
		} else {
			a = t / 300;
			t -= a * 300;
			b = t / 60;
			t -= b * 60;
			c = t / 10;
			System.out.println(a + " " + b + " " + c);
		}
	}

}
