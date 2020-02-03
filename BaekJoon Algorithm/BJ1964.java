import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1964 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(reader.readLine());

		System.out.println(((N * N * 3 + N * 5 + 2) / 2) % 45678);
	}
}
