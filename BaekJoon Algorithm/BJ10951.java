import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10951 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		while (true) {
			String s = reader.readLine();
			if (s == null || s.trim().equals("") || s.isEmpty())
				break;
			tokenizer = new StringTokenizer(s);
			int A = Integer.parseInt(tokenizer.nextToken());
			int B = Integer.parseInt(tokenizer.nextToken());

			System.out.println(A + B);

		}
	}
}
