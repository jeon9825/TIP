import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1783 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		
		if (n == 1)
			System.out.println(1);
		else if (n == 2)
			System.out.println(Math.min(4, (m + 1) / 2));
		else if (n >= 3) {
			if (m <= 6)
				System.out.println(Math.min(4, m));
			else
				System.out.println(m - 2);
		}
	}
}
