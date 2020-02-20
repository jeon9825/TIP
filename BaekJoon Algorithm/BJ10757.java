import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ10757 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String[] n = s.split(" +");
		BigInteger N1 = new BigInteger(n[0]);
		BigInteger N2 = new BigInteger(n[1]);

		System.out.println(N1.add(N2));
	}

}
