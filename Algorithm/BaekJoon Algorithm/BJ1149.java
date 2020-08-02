import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		int[] cost = new int[3];
		
		StringTokenizer tokenizer;
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int[] home = new int[3];
			for (int j = 0; j < home.length; j++) {
				home[j] = Integer.parseInt(tokenizer.nextToken());
			}
			if (i == 0)
				cost = home;
			else {
				for (int j = 0; j < home.length; j++) {
					int min = Integer.MAX_VALUE;
					int minIndex = -1;
					for (int j2 = 0; j2 < cost.length; j2++) {
						if (j != j2) {
							if (cost[j2] < min) {
								min = cost[j2];
								minIndex = j2;
							}
						}
					}
					home[j] += cost[minIndex];
				}
				cost = home;
			}
		}
		Arrays.sort(cost);
		System.out.println(cost[0]);
	}
}
