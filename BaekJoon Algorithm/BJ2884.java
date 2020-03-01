import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2884 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int H = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		if (M >= 45) {
			int M_45 = M - 45;
			System.out.println(H + " " + M_45);
		} else {
			if (H == 0) {
				int H_24 = 23;
				int M_15 = M + 15;
				System.out.println(H_24 + " " + M_15);

			} else {
				int M_15 = M + 15;
				System.out.println(H - 1 + " " + M_15);
			}
		}
	}
}
