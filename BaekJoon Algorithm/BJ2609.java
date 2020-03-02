import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2609 {
	public static void swap(int n1, int n2) {
		int p = n1;
		n1 = n2;
		n2 = p;
	}

	public static int uclid(int n1, int n2) { // 최대 공약수
		if (n1 < n2)
			swap(n1, n2);
		if (n2 == 0)
			return 0;
		if (n1 % n2 == 0)
			return n2;
		return uclid(n2, n1 % n2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int x = Integer.parseInt(tokenizer.nextToken());
		int y = Integer.parseInt(tokenizer.nextToken());
		int gcd = uclid(x, y);
		int gcm = x * y / gcd;
		System.out.println(gcd);
		System.out.println(gcm);
	}
}
