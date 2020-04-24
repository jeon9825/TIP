import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		
		s= s.replaceAll("c=", "0");
		s= s.replaceAll("c-", "0");
		s= s.replaceAll("dz=", "0");
		s= s.replaceAll("d-", "0");
		s= s.replaceAll("lj", "0");
		s= s.replaceAll("nj", "0");
		s= s.replaceAll("s=", "0");
		s= s.replaceAll("z=", "0");
		System.out.println(s.length());
	}
}
