import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2742 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for (int i = N; i > 0; i--) {
			System.out.println(i);
		}
	}
}
