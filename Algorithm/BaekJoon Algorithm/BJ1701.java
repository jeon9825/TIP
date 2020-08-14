import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 패턴 테이블

public class BJ1701 {
	static int[] table;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			int m = solve(s.substring(i));
			if (max < m)
				max = m;
		}

		System.out.println(max);
	}

	static int solve(String s) {
		char[] c = s.toCharArray();
		int[] table = new int[c.length];

		int j = 0;
		for (int i = 1; i < c.length; i++) {
			while (j > 0 && c[i] != c[j])
				j = table[j - 1];
			if (c[i] == c[j]) {
				table[i] = ++j;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < c.length; i++) {
			max = Math.max(table[i], max);
		}
		return max;
	}
}
