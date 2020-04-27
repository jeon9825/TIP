import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2581 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());

		boolean[] b = new boolean[n + 1];
		b[1] = true;
		for (int i = 2; i < b.length; i++) {
			for (int j = 2; i * j < b.length; j++) {
				if (!b[i * j])
					b[i * j] = true;
			}
		}
		int min = Integer.MAX_VALUE;
		int sum = 0;
		boolean check = false;
		for (int i = m; i < b.length; i++) {
			if (!b[i]) {
				check = true;
				min = Math.min(min, i);
				sum += i;
			}
		}
		if (check) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

}
