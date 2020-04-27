import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1978 {
	static boolean Bcount(int num) {
		if (num == 1)
			return false;
		for (int j = 2; j < num; j++) {
			if (num % j == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine()); // 연산의 개수
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] num = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if(Bcount(num[i]))
				count++;
		}
		System.out.println(count);
	}
}
