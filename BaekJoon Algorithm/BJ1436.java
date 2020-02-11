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
		System.out.println(--sum); // �������� con(sum++)���� ++�� ���ְ� while ���� ����ϱ� �ٽ� -1 ����� ��.
	}
}
