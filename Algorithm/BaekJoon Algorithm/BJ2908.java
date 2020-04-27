import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2908 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		StringBuilder A = new StringBuilder(tokenizer.nextToken());
		StringBuilder B = new StringBuilder(tokenizer.nextToken());

		int nA = Integer.parseInt(A.reverse().toString());
		int nB = Integer.parseInt(B.reverse().toString());
		System.out.println(nA > nB ? nA : nB);
	}

}
