import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(reader.readLine());

		System.out.printf("%f\n", R * R * Math.PI);
		System.out.printf("%f\n", R * R * 2.0); // |x|+|y|=R �������� ũ�� 2R*2R/2
	}

}
