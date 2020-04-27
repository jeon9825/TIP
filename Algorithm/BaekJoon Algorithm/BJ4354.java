import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4354 {
	static int san(String s, int l) {
		String s1 = s.substring(0, l);
		int n = s.length() / l;
		boolean b = false;
		for (int i = 1; i < n; i++) {
			if (s1.equals(s.substring(l * i, l * (i + 1))))
				b = true;
			else {
				b = false;
				break;
			}
		}
		return b ? n : 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (true) {
			s = reader.readLine();
			if (s.equals("."))
				break;
			int max = 1;
			for (int i = 1; i <= s.length() / 2; i++) {
				if (s.length() % i == 0) {
					int san = san(s, i);
					if (max < san) {
						max = san;
						break;
					}
				}
			}
			System.out.println(max);
		}
	}
}
