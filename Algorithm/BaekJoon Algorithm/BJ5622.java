import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ5622 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		char[] c=s.toCharArray();
		int[] m = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10 };
//		byte[] bytes = s.getBytes("US-ASCII");
		int sum = 0;
		for (int i = 0; i < c.length; i++) { //bytes.length
//			sum += m[bytes[i] - 65];
			sum+=m[c[i]-'A'];
		}
		System.out.println(sum);
	}

}
