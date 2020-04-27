import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11365 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = reader.readLine();
			if (s.equals("END"))
				break;
			System.out.println(new StringBuilder(s).reverse().toString());
		}
	}
}
