import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3613 {
	static void cppToJava(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '_') {
				sb.append((char) (s.charAt(i + 1) - 32));
				i++;
				continue;
			}
			sb.append(s.charAt(i));
		}
		System.out.println(sb.toString());
	}

	static void javaToCpp(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				sb.append("_" + (char) (s.charAt(i) + 32));
				continue;
			}
			sb.append(s.charAt(i));
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		if (s.matches("^[a-z][_a-z]*$") && !s.contains("__") && s.charAt(0) != '_' && s.charAt(s.length() - 1) != '_') {
			cppToJava(s);
		} else if (s.matches("^[a-z][a-zA-Z]*$")) {
			javaToCpp(s);
		} else {
			System.out.println("Error!");
		}
	}
}
