import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Set<Integer> set = new HashSet<>();
		StringTokenizer tokenizer;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			String s = tokenizer.nextToken();
			if (s.equals("add")) {
				int num = Integer.parseInt(tokenizer.nextToken());
				set.add(num);
			} else if (s.equals("remove")) {
				int num = Integer.parseInt(tokenizer.nextToken());
				set.remove(num);
			} else if (s.equals("check")) {
				int num = Integer.parseInt(tokenizer.nextToken());
				sb.append((set.contains(num) ? 1 : 0) + "\n");
			} else if (s.equals("toggle")) {
				int num = Integer.parseInt(tokenizer.nextToken());
				if (!set.contains(num)) {
					set.add(num);
				} else {
					set.remove(num);
				}
			} else if (s.equals("all")) {
				for (int j = 0; j < 20; j++) {
					set.add(j + 1);
				}
			} else if (s.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb.toString());
	}
}
