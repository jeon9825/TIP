import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10998 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		System.out.println(a * b);
	}
}
