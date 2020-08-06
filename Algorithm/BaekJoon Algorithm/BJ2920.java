import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[8];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		num[0] = Integer.parseInt(tokenizer.nextToken());

		boolean b = true;
		if (num[0] == 1) {
			for (int i = 1; i < num.length; i++) {
				num[i] = Integer.parseInt(tokenizer.nextToken());
				if (i != num[i]-1) {
					b = false;
					break;
				}
			}
			if (b)
				System.out.println("ascending");
		} else if (num[0] == 8) {
			for (int i = 1; i < num.length; i++) {
				num[i] = Integer.parseInt(tokenizer.nextToken());
				if (num[i] != 8 - i) {
					b = false;
					break;
				}
			}
			if (b)
				System.out.println("descending");
		} else {
			b = false;
		}
		if (!b)
			System.out.println("mixed");
	}
}
