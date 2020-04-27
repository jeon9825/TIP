import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1316 {
	public static boolean count(String s) {
		char[] c = s.toCharArray();
		boolean[] b = new boolean['z' - 'a' + 1];
		Arrays.fill(b, true);
		Character cO = c[0];
		for (int j = 0; j < c.length; j++) {
			if (cO != c[j]) {
				b[cO - 'a'] = false;
				cO = c[j];
			}
			if (!b[c[j] - 'a']) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		int count = 0;

		for (int i = 0; i < N; i++) {
			String s = reader.readLine();
			if (count(s))
				count++;
		}

		System.out.println(count);

	}

}
