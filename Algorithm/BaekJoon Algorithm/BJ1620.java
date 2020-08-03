import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1620 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String s = reader.readLine();
			map.put(Integer.toString(i + 1), s);
			map.put(s, Integer.toString(i + 1));
		}

		for (int i = 0; i < m; i++) {
			String s = reader.readLine();
			System.out.println(map.get(s));
		}
	}
}
