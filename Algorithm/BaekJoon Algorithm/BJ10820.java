import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10820 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = reader.readLine();
			if (s == null || s.equals(""))
				break;
			char[] c = s.toCharArray();
			int lc = 0;
			int uc = 0;
			int num = 0;
			int space = 0;
			for (int i = 0; i < c.length; i++) {
				if (c[i] >= 97 && c[i] <= 122)
					lc++;
				else if (c[i] >= 65 && c[i] <= 90)
					uc++;
				else if (c[i] >= 48 && c[i] <= 57)
					num++;
				else if (c[i] == 32)
					space++;
			}
			System.out.println(lc + " " + uc + " " + num + " " + space);
		}
	}
}
