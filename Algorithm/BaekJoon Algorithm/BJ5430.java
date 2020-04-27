import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BJ5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		char r = 'R';
		char d = 'D';
		boolean b = false; // 뒤집힘
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테스트 케이스의 개수

		for (int i = 0; i < T; i++) {

			char[] p = reader.readLine().toCharArray();
			int n = Integer.parseInt(reader.readLine());
			Integer[] x = new Integer[n];
			String s = reader.readLine();
			String[] sx = s.substring(1, s.length() - 1).split(",");
//			for (int j = 0; j < x.length; j++) {
//				x[j] = Integer.parseInt(sx[j]);
//			}

			List<String> list = new ArrayList<>(Arrays.asList(sx));

			for (int j = 0; j < p.length; j++) {
				if (p[j] == r) {
					if (b == false)
						b = true;
					else
						b = false;
				} else if (p[j] == d && !list.isEmpty()) {
					if (b == false)
						list.remove(0);
					else
						list.remove(list.size() - 1);
				}
			}
	
			if (b)
				Collections.reverse(list);

			if (list.isEmpty() || list == null) {
				System.out.println("error");
				continue;
			}
			System.out.print("[");
			for (int j = 0; j < list.size(); j++) {
				if (j != 0)
					System.out.print(",");
				System.out.print(list.get(j));
			}
			System.out.println("]");
		}
	}
}
