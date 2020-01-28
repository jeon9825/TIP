import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1037 {

	public static void main(String[] args)throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i]=Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(A);
		System.out.println(A[0]*A[A.length-1]);
	}

}
