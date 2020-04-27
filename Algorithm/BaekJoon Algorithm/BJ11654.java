import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11654 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int c = reader.readLine().charAt(0)-0;
		System.out.printf("%d",c);
	}
}
