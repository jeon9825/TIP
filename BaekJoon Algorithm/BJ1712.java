import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1712 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(reader.readLine());

		int A = Integer.parseInt(s.nextToken());
		int B = Integer.parseInt(s.nextToken());
		int C = Integer.parseInt(s.nextToken());
		if (C - B <= 0)
			System.out.println(-1);
		else {
			System.out.println(A / (C - B) + 1); // int ³ª´°¼ÀÀº ¿Ã¸²À» ÇØÁà¾ß ÇÔ (+1 ÇÏ´Â ÀÌÀ¯)
		}

	}

}
