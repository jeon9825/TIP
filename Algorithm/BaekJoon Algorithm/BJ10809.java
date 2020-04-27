import java.util.Scanner;

public class BJ10809 {

	static int[] position(String s) {

		char[] c = s.toCharArray();
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int[] position = new int[26];
		for (int i = 0; i < position.length; i++) {
			position[i] = -1;
		}
		for (int i = 0; i < alphabet.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (alphabet[i] == c[j]) {
					position[i] = j;
					break;
				}
			}
		}
		return position;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int[] position = position(s);
		for (int i = 0; i < position.length; i++) {
			System.out.print(position[i] + " ");
		}
	}

}
