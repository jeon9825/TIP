import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}

		HashMap<Integer, Integer> map = new HashMap<>();

		int[] arr2 = new int[n];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr[i];
		}
		Arrays.sort(arr2);

		int idx = 1;
		for (int i = 0; i < arr2.length; i++) {
			if (!map.containsKey(arr2[i]))
				map.put(arr2[i], idx++);
			else
				continue;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(map.get(arr[i]) - 1 + " ");
		}
	}
}
