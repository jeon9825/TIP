import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1764 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		HashSet<String> setN = new HashSet<>();
		for (int i = 0; i < n; i++) {
			setN.add(reader.readLine());
		}
		HashSet<String> setM = new HashSet<>();
		for (int i = 0; i < m; i++) {
			setM.add(reader.readLine());
		}

		setN.retainAll(setM);
		
		System.out.println(setN.size());
		
		String[] s = new String[setN.size()];
		s= setN.toArray(s);
		
		Arrays.sort(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}
