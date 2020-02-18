import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1075 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int F = Integer.parseInt(reader.readLine());
		int i = (N / 100) * 100;
		while (true) {
			if (i % F == 0)
				break;
			i++;
		}
		System.out.printf("%02d", i % 100);
	}
}
