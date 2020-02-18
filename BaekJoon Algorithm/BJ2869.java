import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2869 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int A = Integer.parseInt(tokenizer.nextToken());
		int B = Integer.parseInt(tokenizer.nextToken());
		int V = Integer.parseInt(tokenizer.nextToken());

// 시간초과
//		int date = 0;
//		int distance = 0;
//		while (distance != V) {
//			date++;
//			distance += A;
//			if (distance == V)
//				break;
//			distance -= B;
//		}

		// V <= A * (date + 1) - B * date
		// V - A <= (A - B) * date
		// (V - A) / (A - B) <= date
		// Math.ceil((V - A) / (A - B)) == date
		// "date + 1"이 기준! date +1 == Math.ceil((V - B) / (A - B)) + 1
		System.out.println((int) Math.ceil((double) (V - A) / (A - B)) + 1);

		// V <= A * date - B * (date - 1)
		// V - B <= (A - B) * date
		// (V - B) / (A - B) <= date
		// Math.ceil((V - B) / (A - B)) == date
		// "date"이 기준!
		// System.out.println((int) Math.ceil((double) (V - B) / (A - B)));
	}
}
