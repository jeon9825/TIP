import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1259 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (true) {
			s = reader.readLine();
			if (s.equals("0"))
				break;

			char[] c = s.toCharArray();
			boolean b = true;
			for (int i = 0; i < c.length / 2; i++) {
				if (c[i] != c[c.length - 1 - i]) {
					b = false;
					break;
				}
			}
			System.out.println(b ? "yes" : "no");
		}
	}
}
