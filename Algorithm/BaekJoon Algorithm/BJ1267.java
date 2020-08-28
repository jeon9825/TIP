import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1267 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int Y = 0;
		int M = 0;
		for (int i = 0; i < n; i++) {
			int time = Integer.parseInt(tokenizer.nextToken());
			for (int j = 0; j <= time; j += 30) {
				Y += 10;
			}

			for (int j = 0; j <= time; j += 60) {
				M += 15;
			}
		}

		System.out.println(Y < M ? "Y " + Y : M < Y ? "M " + M : "Y M " + Y);
	}
}
