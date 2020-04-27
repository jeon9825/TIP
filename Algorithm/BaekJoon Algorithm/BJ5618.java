import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5618 {

//	public static void swap(int n1, int n2) {
//		int p = n1;
//		n1 = n2;
//		n2 = p;
//	}

//	public static void uclid(int n1, int n2) { //최대 공약수
//		if (n1 < n2)
//			swap(n1, n2);
//
//		if (n2 == 0)
//			return;
//
//		int r = n1 % n2;
//		if (r == 0) 
//			System.out.println(n2);
//		
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n1, n2, n3;

		switch (n) {
		case 2:
			n1 = Integer.parseInt(tokenizer.nextToken());
			n2 = Integer.parseInt(tokenizer.nextToken());
			for (int i = 1; i <= n1 && i <= n2; i++) {
				if (n1 % i == 0 && n2 % i == 0)
					System.out.println(i + " ");
			}
			break;
		case 3:
			n1 = Integer.parseInt(tokenizer.nextToken());
			n2 = Integer.parseInt(tokenizer.nextToken());
			n3 = Integer.parseInt(tokenizer.nextToken());
			for (int i = 1; i <= n1 && i <= n2 && i <= n3; i++) {
				if (n1 % i == 0 && n2 % i == 0 && n3 % i == 0)
					System.out.println(i + " ");
			}
			break;
		}

	}
}
