import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11170 {
	static int cnt0(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			String s = String.valueOf(i);
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '0')
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			System.out.println(cnt0(a, b));
		}
	}
}
