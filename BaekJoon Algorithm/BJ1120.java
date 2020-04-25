import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		String a = new String(tokenizer.nextToken());
		String b = new String(tokenizer.nextToken());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < b.length() - a.length() + 1; i++) {
			int m = 0;
			String bSub = b.substring(i, i + a.length());
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) != bSub.charAt(j)) {
					m++;
				}
			}
			min = Math.min(min, m);
		}
		System.out.println(min);
	}
}
