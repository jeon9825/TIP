import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1436 {
	public static boolean con(int sum) {
		String s = String.valueOf(sum);
		return s.indexOf("666") >= 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		int count = 0;
		int sum = 0;
		while (count != N) {
			if (con(sum++)) {
				count++;
			}
		}
		System.out.println(--sum); // 마지막에 con(sum++)에서 ++를 해주고 while 문을 벗어나니깐 다시 -1 해줘야 함.
	}
}
