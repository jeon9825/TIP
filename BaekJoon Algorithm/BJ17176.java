import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17176 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = Integer.parseInt(tokenizer.nextToken());
		}
		char[] s = reader.readLine().toCharArray();
		int[] ps = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ')
				ps[i] = 0;
			else if (65 <= s[i] && s[i] <= 90) {
				ps[i] = s[i]-64;
			} else if (97 <= s[i] && s[i] <= 122) {
				ps[i] = s[i]-70;
			}
		}
		Arrays.sort(ps);
		Arrays.sort(p);
		System.out.println(Arrays.equals(ps, p)?"y":"n");
	}
}
