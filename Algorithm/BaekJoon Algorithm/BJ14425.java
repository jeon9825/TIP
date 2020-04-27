import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ14425 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(reader.readLine());
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (list.contains(reader.readLine()))
				count++;
		}
		System.out.println(count);
	}
}
