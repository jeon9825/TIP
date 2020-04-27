import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ4641 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = reader.readLine();
			if (s.trim().equals("-1"))
				break;
			StringTokenizer tokenizer = new StringTokenizer(s);
			List<Integer> list = new ArrayList<>();
			while (true) {
				int n = Integer.parseInt(tokenizer.nextToken());
				if (n == 0)
					break;
				list.add(n);
			}

			int count = 0;
			for (Integer i : list) {
				if (list.contains(i * 2))
					count++;
			}
			System.out.println(count);
		}
	}
}
