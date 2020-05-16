import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2331 {
	static int P;

	static int sum(int n) {
		int sum = 0;

		while (n > 0) {
			sum += Math.pow(n % 10, P);
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int A = Integer.parseInt(tokenizer.nextToken());
		P = Integer.parseInt(tokenizer.nextToken());

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list.add(A);
		while (!list.isEmpty()) {
			int Dn1 = list.get(list.size() - 1);
			int Dn = sum(Dn1);
			if (!list.contains(Dn))
				list.add(Dn);
			else {
				if (list2.contains(Dn)) {
					break;
				} else {
					list2.add(Dn);
				}
			}
		}
		int cnt = 0;
		for (Integer i : list) {
			if (!list2.contains(i))
				cnt++;
			else
				break;
		}
		System.out.println(cnt);
	}
}
