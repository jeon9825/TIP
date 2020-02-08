import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1085 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int x = Integer.parseInt(tokenizer.nextToken());
		int y = Integer.parseInt(tokenizer.nextToken());
		int w = Integer.parseInt(tokenizer.nextToken());
		int h = Integer.parseInt(tokenizer.nextToken());

		int min = Math.min(Math.min(x, y), Math.min(w - x, h - y));
		System.out.println(min);
	}

}
