import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int cnt = 0;
		int sing = 1;
		while (n != 0) {
			if (n < sing)
				sing = 1;
			n -= sing;
			sing++;
			cnt++;
		}
		System.out.println(cnt);
	}
}
