import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15953 {
	static int pa(int a) {
		switch (a) {
		case 1:
			return 500;
		case 2:
		case 3:
			return 300;
		case 4:
		case 5:
		case 6:
			return 200;
		case 7:
		case 8:
		case 9:
		case 10:
			return 50;
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
			return 30;
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
		case 21:
			return 10;
		default:
			return 0;
		}
	}

	static int pb(int b) {
		if (b >= 32 || b == 0)
			return 0;
		int p = 32; // »ó±İ
		for (int i = 0; i < 5; i++) {
			if (Math.pow(2, i) <= b && b < Math.pow(2, i + 1)) {
				p *= Math.pow(2, 4 - i);
			}
		}
		return p;
	}

	static int p(int a, int b) {
		return pa(a) + pb(b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			System.out.println(p(a, b) * 10000);
		}
	}
}
