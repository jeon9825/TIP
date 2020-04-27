import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ9375 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(reader.readLine());
			Map<String, Integer> m = new HashMap<>();

			for (int j = 0; j < t; j++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				String name = tokenizer.nextToken();
				String kind = tokenizer.nextToken();
				Integer count = m.get(kind);
				if (count == null)
					count = 0;
				m.put(kind, count + 1);
			}
			int c = 1;
			for (String key : m.keySet()) {
				// System.out.println(String.format("Å° : %s, °ª : %s", key, m.get(key)));
				c *= m.get(key) + 1;
			}
			System.out.println(c-1);
		}
	}

}
