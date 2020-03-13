import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String s = new String(reader.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Character.valueOf(s.charAt(i))-48;
		}
		System.out.println(sum);
	}
}
