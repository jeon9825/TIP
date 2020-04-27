import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2446 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine()); // ют╥б
		for (int i = n; i > 0; i--) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i < n; i++) {
			for (int j = i; j < n - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
