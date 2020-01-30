import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] c = reader.readLine().toCharArray();
		Arrays.sort(c);
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			buffer.append(c[i]);
		}
		System.out.println(buffer.reverse().toString());
	}
}