import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1049 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int pack = Integer.MAX_VALUE;
		int piece = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int nPack = Integer.parseInt(tokenizer.nextToken());
			int nPiece = Integer.parseInt(tokenizer.nextToken());
			pack = Math.min(pack, nPack);
			piece = Math.min(piece, nPiece);
		}

		int min;
		if (N <= 6) {
			min = Math.min(pack, piece * N);
		} else {
			min = Math.min(Math.min(pack * (N / 6 + 1), pack * (N / 6) + piece * (N % 6)), piece * N);
		}
		System.out.println(min);
	}
}
