import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11653 {
	static void pf(int n) {
		int r = 2;
		while (n != 1) {
			if (n % r == 0) {
				n /= r;
				System.out.println(r);
			} else {
				r++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		pf(N);
	}
}
