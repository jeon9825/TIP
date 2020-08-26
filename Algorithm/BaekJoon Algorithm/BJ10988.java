import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10988 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		StringBuilder builder = new StringBuilder(s);
		System.out.println(s.equals(builder.reverse().toString()) ? 1 : 0);
	}
}
