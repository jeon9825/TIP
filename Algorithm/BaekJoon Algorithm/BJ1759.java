import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759 {
	static int L;
	static char[] c;

	static boolean v1c2(String s) {
		char[] ch = s.toCharArray();
		int v = 0; // 모음 개수
		int c = 0; // 자음 개수
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
				v++;
			} else {
				c++;
			}
		}
		if (v >= 1 && c >= 2)
			return true;
		else
			return false;
	}

	static void password(String s, int index) {
		if (s.length() == L) {
			if (v1c2(s)) {
				System.out.println(s);
			}
			return;
		}
		if (index == c.length) {
			return;
		}
		password(s + c[index], index + 1);
		password(s, index + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		L = Integer.parseInt(tokenizer.nextToken());
		int C = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(reader.readLine());
		c = new char[C];
		for (int i = 0; i < c.length; i++) {
			c[i] = tokenizer.nextToken().charAt(0);
		}
		Arrays.sort(c);
//		System.out.println(Arrays.toString(c));
		password("", 0);
	}
}
