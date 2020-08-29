import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2753 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		boolean b = false;
		if (n % 400 == 0)
			b = true;
		else if (n % 4 == 0 && n % 100 != 0)
			b = true;

		System.out.println(b ? 1 : 0);
	}
}
