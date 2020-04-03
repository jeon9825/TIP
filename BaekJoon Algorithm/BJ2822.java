import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2822 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] score1 = new int[8];
		int[] score2;
		for (int i = 0; i < score1.length; i++) {
			score1[i] = Integer.parseInt(reader.readLine());
		}
		score2 = score1.clone();
		Arrays.sort(score1);
		int sum = 0;
		int[] p = new int[5];
		int index = 0;
		for (int i = score1.length - 1; i > score1.length - 6; i--) {
			for (int j = 0; j < score2.length; j++) {
				if (score1[i] == score2[j]) {
					sum += score1[i];
					p[index++] = j + 1;
				}
			}
		}
		Arrays.sort(p);
		System.out.println(sum);
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}
	}
}
