import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ7785 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String s = tokenizer.nextToken();
			String enterOrLeave = tokenizer.nextToken();
			if (enterOrLeave.equals("enter")) {
				set.add(s);
			} else if (enterOrLeave.equals("leave")) {
				set.remove(s);
			}
		}
		String[] s= set.toArray(new String[] {});
		Arrays.sort(s,Collections.reverseOrder());
		for (String str : s) {
			System.out.println(str);
		}
	}
}
