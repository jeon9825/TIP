import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10950 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int A = Integer.parseInt(tokenizer.nextToken());
			int B = Integer.parseInt(tokenizer.nextToken());
			
			System.out.println(A+B);
		}
	}
}
