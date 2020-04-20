import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ11652 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Map<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(reader.readLine());
			if (map.containsKey(num)) {
				int value = map.get(num);
				map.replace(num, value + 1);
			} else {
				map.put(num, 1);
			}
		}
		int max = Integer.MIN_VALUE;
		long k = Long.MAX_VALUE;
		for (Long key : map.keySet()) {
			int value = map.get(key);
			if (max < value || (max == value && k > key)) {
				max = value;
				k = key;
			}
		}
		System.out.println(k);
	}
}
