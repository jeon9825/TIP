import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5086 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int m, n;
		while (true) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			m = Integer.parseInt(tokenizer.nextToken());
			n = Integer.parseInt(tokenizer.nextToken());
			if (m == 0 && n == 0)
				break;
			if (n % m == 0)
				System.out.println("factor");
			else if (m % n == 0)
				System.out.println("multiple");
			else
				System.out.println("neither");
		}
	}
}
