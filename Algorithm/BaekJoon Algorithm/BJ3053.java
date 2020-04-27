import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(reader.readLine());

		System.out.printf("%f\n", R * R * Math.PI);
		System.out.printf("%f\n", R * R * 2.0); // |x|+|y|=R 마름모의 크기 2R*2R/2
	}

}
