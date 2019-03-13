import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ1157 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		char[] c = s.toUpperCase().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char key : c) {
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}
		int max = -1;
		Character maxChar = '?';
		for (Character key : map.keySet()) {
			if (max < map.get(key)) {
				max = map.get(key);
				maxChar = key;
			} else if (max == map.get(key)) {
				max = map.get(key);
				maxChar = '?';
			}
		}
		if (maxChar == '?')
			System.out.println(maxChar);
		else
			System.out.println(maxChar);
	}
}
