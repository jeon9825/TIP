import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1929 { // 에라토스테네스의 체

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int M = Integer.parseInt(tokenizer.nextToken());
		int N = Integer.parseInt(tokenizer.nextToken());
		boolean[] primeNum = new boolean[N + 1];
		primeNum[1] = true; // 1은 소수가 아님
		for (int i = 2; i < primeNum.length; i++) {
			for (int j = 2; i * j < primeNum.length; j++) {
				primeNum[i * j] = true; // 소수가 아니면 true를 넣어줌
			}
		}

		for (int i = M; i <= N; i++) {
			if (!primeNum[i])
				System.out.println(i);
		}
	}
}
