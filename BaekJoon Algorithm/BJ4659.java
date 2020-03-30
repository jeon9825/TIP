import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4659 {
	static boolean checkVowel(String s) {
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
				return true;
			}
		}
		return false;
	}

	static boolean cv(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	static boolean checkVo2(String s) {
		if (s.length() >= 2) {
			char[] ch = s.toCharArray();
			char c1;
			char c2;

			for (int i = 0; i < ch.length - 1; i++) {
				c1 = ch[i];
				c2 = ch[i + 1];

				if ((c1 == 'e' && c2 == 'e') || (c1 == 'o' && c2 == 'o')) {
					continue;
				} else {
					if (c1 == c2) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static boolean checkVo3(String s) {
		if (s.length() >= 3) {
			char[] ch = s.toCharArray();
			char c1;
			char c2;
			char c3;
			for (int i = 0; i < ch.length - 2; i++) {
				c1 = ch[i];
				c2 = ch[i + 1];
				c3 = ch[i + 2];

				if (cv(c1) && cv(c2) && cv(c3)) { // 다 모음이면
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkCo3(String s) {
		if (s.length() >= 3) {
			char[] ch = s.toCharArray();
			char c1;
			char c2;
			char c3;
			for (int i = 0; i < ch.length - 2; i++) {
				c1 = ch[i];
				c2 = ch[i + 1];
				c3 = ch[i + 2];
				if (!cv(c1) && !cv(c2) && !cv(c3)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (true) {
			s = reader.readLine();
			if (s.equals("end"))
				break;
			if (checkVowel(s) && checkVo3(s) && checkVo2(s) && checkCo3(s)) {
				System.out.println("<" + s + "> is acceptable.");
			} else {
				System.out.println("<" + s + "> is not acceptable.");
			}
		}
	}
}
