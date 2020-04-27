import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int c = Integer.parseInt(reader.readLine());

		int num = a * b * c;
		int[] count = new int[10];
		while (true) {
			int r = num % 10;
			count[r]++;
			num /= 10;
			if (num <= 0)
				break;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
