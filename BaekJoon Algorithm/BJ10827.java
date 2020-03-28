import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BJ10827 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		BigDecimal a = BigDecimal.valueOf(Double.parseDouble(tokenizer.nextToken()));
		int b = Integer.parseInt(tokenizer.nextToken());
		BigDecimal ans = a.pow(b);
		System.out.println(ans.toPlainString());
	}
}
