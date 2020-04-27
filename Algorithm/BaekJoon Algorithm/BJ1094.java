import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1094 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(reader.readLine());
		int min = 64;
		int sum = 0;
		int count = 0;

		while (true) {
			if (min / 2 >= X) {
				min /= 2;
			}else {
				break;
			}
		}

//		System.out.println(min);
		
		if (min == X) {
			sum = min;
			count++;
		}

		while (sum != X) {
			min /= 2;
			if (sum + min <= X) {
				sum += min;
				count++;
			}
		}
		System.out.println(count);
	}
}
