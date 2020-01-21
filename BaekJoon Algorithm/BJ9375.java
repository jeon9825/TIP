import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ9375 {

	public static int count(int t) {
		Map<String, Integer> m = new HashMap<>();
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < t; i++) {
			String s = scan.nextLine();
			String[] sarr = s.split(" ");
			if (!m.containsKey(sarr[1]))
				m.put(sarr[1], 1);
			else
				m.replace(sarr[1], m.get(sarr[1]) + 1);
		}
		int c = 1;
		for (String key : m.keySet()) {
			// System.out.println(String.format("Å° : %s, °ª : %s", key, m.get(key)));
			c *= m.get(key) + 1;
		}
		return c - 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(reader.readLine());
			System.out.println(count(t));
		}
	}

}
