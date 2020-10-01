import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ17219 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			map.put(tokenizer.nextToken(), tokenizer.nextToken());
		}

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < m; i++) {
			writer.write(map.get(reader.readLine()) + "\n");
		}
		writer.flush();
	}
}
