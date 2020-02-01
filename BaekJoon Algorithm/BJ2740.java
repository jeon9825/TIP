import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2740 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int NA = Integer.parseInt(tokenizer.nextToken());
		int MA = Integer.parseInt(tokenizer.nextToken());
		int[][] A = new int[NA][MA];
		for (int i = 0; i < A.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		tokenizer = new StringTokenizer(reader.readLine());
		int NB = Integer.parseInt(tokenizer.nextToken());
		int MB = Integer.parseInt(tokenizer.nextToken());
		int[][] B = new int[NB][MB];
		for (int i = 0; i < B.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < B[i].length; j++) {
				B[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		int[][] C = new int[NA][MB];
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				for (int k = 0; k < MA; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}

}
