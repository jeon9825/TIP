import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BJ1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String s = reader.readLine();
			if (!list.contains(s))
				list.add(s);
		}

		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o2.length() - o1.length() != 0)
					return o1.length() - o2.length();
				else {
					return o1.compareTo(o2);
				}
			}

		};
		list.sort(c);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
