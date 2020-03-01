import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2744 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('A' <= c && c <= 'Z')
				System.out.print(String.valueOf(c).toLowerCase());
			else if ('a' <= c && c <= 'z')
				System.out.print(String.valueOf(c).toUpperCase());
		}
	}
}
