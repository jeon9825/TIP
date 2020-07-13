import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1541 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split("\\-");

		int ans = 0;
		for (int i = 0; i < str.length; i++) {

			String[] data = str[i].split("\\+");
			int sum = 0;
			for (int j = 0; j < data.length; j++) {
				sum += Integer.parseInt(data[j]);
			}
			if (i == 0)
				sum *= -1;
			ans -= sum;
		}
		System.out.println(ans);

	}
}
