import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1057 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int kim = Integer.parseInt(tokenizer.nextToken());
		int lim = Integer.parseInt(tokenizer.nextToken());
		int count = 0;
		while (N >= 0) {
			count++;
			kim = (kim + 1) / 2;
			lim = (lim + 1) / 2;
			if (kim == lim)
				break;
			N /= 2;
		}
		if (count > 0) 
			System.out.println(count);
		else
			System.out.println(-1);
	}
}
