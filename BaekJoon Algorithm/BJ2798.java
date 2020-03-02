import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2798 {

	static int blackJack(int[] card, int M) {
		int sum = 0;
		int A, B, C;
		int temp = 0;
		for (int i = 0; i < card.length; i++) {
			A = card[i];
			for (int j = i + 1; j < card.length; j++) {
				B = card[j];
				for (int k = j + 1; k < card.length; k++) {
					C = card[k];
					sum = A + B + C;
					if (sum == M) {
						temp = sum;
					} else if (sum < M) {
						temp = Math.abs(temp - M) > Math.abs(sum - M) ? sum : temp;
					}
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int[] card = new int[N];
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(tokenizer.nextToken());
		}

		System.out.println(blackJack(card, M));
	}
}
