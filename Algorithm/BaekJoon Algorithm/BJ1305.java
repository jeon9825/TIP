import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 패턴 테이블

public class BJ1305 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(reader.readLine());
		char[] s = reader.readLine().toCharArray();
		int[] table = new int[l];

		int j = 0;

		for (int i = 1; i < s.length; i++) {
			while (j > 0 && s[i] != s[j])
				j = table[j - 1];
			if (s[i] == s[j])
				table[i] = ++j;
		}

		System.out.println(l - table[l - 1]);
	}
}
