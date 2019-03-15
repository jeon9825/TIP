import java.util.ArrayList;
import java.util.List;

public class BJ4673 {
	static int d(int n) {
		int thousand = n / 1000;
		int hundred = n % 1000 / 100;
		int decimal = n % 1000 % 100 / 10;
		int units = n % 1000 % 100 % 10;
		return n + thousand + hundred + decimal + units;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10000; i++) {
			list.add(i);
		}

		for (int i = 1; i <= 10000; i++) {
			if (list.contains(d(i)))
				list.remove(list.indexOf(d(i)));
		}

		for (int i = 0; i < list.toArray().length; i++) {
			System.out.println(list.get(i));
		}
	}
}
