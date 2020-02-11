import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int R = Integer.parseInt(tokenizer.nextToken());
			char[] s = tokenizer.nextToken().toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length; j++) {
				for (int j2 = 0; j2 < R; j2++) {
					sb.append(s[j]);
				}
			}
			System.out.println(sb.toString());
		}

	}
}
