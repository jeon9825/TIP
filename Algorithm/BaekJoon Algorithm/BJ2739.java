import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2739 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		for (int i = 1; i <= 9; i++) {
			int mul = n * i;
			System.out.println(n + " * " + i + " = " + mul);
		}
	}
}
