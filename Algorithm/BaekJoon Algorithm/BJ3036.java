import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3036 {
	public static void swap(int n1, int n2) {
		int p = n1;
		n1 = n2;
		n2 = p;
	}

	public static int gcd(int a, int b) {// a 는 큰 수, b 는 작은 수
		if (a < b)
			swap(a, b);
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int firstCircle = Integer.parseInt(tokenizer.nextToken());

		int[] circle = new int[N - 1];
		for (int i = 0; i < circle.length; i++) {
			circle[i] = Integer.parseInt(tokenizer.nextToken());
		}

		for (int i = 0; i < circle.length; i++) {
			int cd = gcd(circle[i], firstCircle); // 최대공약수 구함
			System.out.println(firstCircle / cd + "/" + circle[i] / cd);
		}
	}
}
