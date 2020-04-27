import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] c = reader.readLine().toCharArray();
		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			sum += c[i] - '0';
		}
		String s;
//		System.out.println(sum);
		if (sum % 3 != 0)
			s = "-1";
		else {
			Arrays.sort(c);
//			System.out.println(Arrays.toString(c));
			if (c[0] != '0')
				s = "-1";
			else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < c.length; i++) {
					sb.append(c[i]);
				}
				s = sb.reverse().toString();
			}
		}
		System.out.println(s);
	}
}
