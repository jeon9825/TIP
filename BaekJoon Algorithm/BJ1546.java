import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		double[] sub = new double[N];
		for (int i = 0; i < sub.length; i++) {
			sub[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(sub);
	
		for (int i = 0; i < sub.length; i++) {
			sub[i] = sub[i] / sub[sub.length - 1] * 100;
		}
		double sum = 0;
		for (int i = 0; i < sub.length; i++) {
			sum+=sub[i];
		}
		System.out.println(sum / N);

	}

}
