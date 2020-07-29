import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1138 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] tall = new int[n];

		for (int i = 0; i < tall.length; i++) {
			tall[i] = Integer.parseInt(tokenizer.nextToken());
		}

		for (int i = tall.length - 1; i >= 0; i--) {
			list.add(tall[i], i + 1);
		}

		for (int i : list) {
			System.out.print(i + " ");
		}
	}

}
