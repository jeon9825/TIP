import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2576 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int min = Integer.MAX_VALUE;
		boolean b = false;
		for (int i = 0; i < 7; i++) {
			int n = Integer.parseInt(reader.readLine());
			if (n % 2 == 1) {
				b = true;
				sum += n;
				min = Math.min(min, n);
			}
		}
		if (b) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

}
