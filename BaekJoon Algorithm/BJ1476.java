import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1476 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int E = Integer.parseInt(tokenizer.nextToken());
		int S = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int year = 0;
		int e = 0, s = 0, m = 0;
		while (true) {
			year++;
			e++;
			s++;
			m++;
			if (e == 16) {
				e = 1;
			}
			if (s == 29) {
				s = 1;
			}
			if (m == 20) {
				m = 1;
			}
			if (e == E && s == S && m == M) {
				System.out.println(year);
				break;
			}
		}
	}
}
