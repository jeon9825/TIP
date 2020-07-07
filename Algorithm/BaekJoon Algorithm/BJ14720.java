import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int s = 0;
		int c = 0;
		int b = 0;
		int[] street = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < street.length; i++) {
			street[i] = Integer.parseInt(tokenizer.nextToken());
			if (s == 0 && street[i] == 0) {
				s++;
			} else {
				if (s > c && street[i] == 1) {
					c++;
				} else if (s == c && c > b && street[i] == 2) {
					b++;
				} else if (s == c && c == b && street[i] == 0) {
					s++;
				}
			}
		}
		System.out.println(s + c + b);
	}
}
