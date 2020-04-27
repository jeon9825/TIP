import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2757 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		while (true) {
			tokenizer = new StringTokenizer(reader.readLine(), "RC");
			int n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			if (n == 0 && m == 0)
				break;
			StringBuilder sb = new StringBuilder();
			while (true) {
				m--;
				char ch = (char) (m % 26 + 65);
				sb.append(String.valueOf(ch));
				m /= 26;
				if (m == 0)
					break;
			}
			System.out.println(sb.reverse().toString() + n);
		}
	}
}
