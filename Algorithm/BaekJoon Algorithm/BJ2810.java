import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2810 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[] c = reader.readLine().toCharArray();
		int count = 1;

		int L = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'S')
				count++;
			else {
				if (L == 0) {
					L++;
				} else {
					count++;
					L = 0;
				}
			}
		}
		if (n >= count)
			System.out.println(count);
		else
			System.out.println(n);
	}
}
