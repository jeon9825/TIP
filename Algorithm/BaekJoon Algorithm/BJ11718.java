import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11718 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (true) {
			s = (reader.readLine());
			if (s == null)
				break;
			System.out.println(s);
		}
	}

}
