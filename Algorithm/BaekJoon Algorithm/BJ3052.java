import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] rest = new int[42];
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(reader.readLine());
			rest[N % 42]++;
		}
		int cnt = 0;
		for (int i = 0; i < rest.length; i++) {
			if (rest[i] != 0)
				cnt++;
		}
		System.out.println(cnt);
	}
}
