import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(i, i + 1);
		}
		int[] nList = new int[N]; // 삭제되는 순서대로 nList에 넣음

		int j = K - 1; // 삭제할 인덱스 j

		for (int i = 0; i < nList.length; i++) { // 인덱스 i로 삭제된 것을 nList를 채움
			if (!(0 <= j && j < list.size())) { // 인덱스 j의 사이즈가 list의 크기를 넘어가면
				j = j % list.size(); // 인덱스 j를 변경
			}
			nList[i] = list.remove(j);
			j = j + K - 1; // -1를 하는 이유: 방금 삭제한 것을 인덱스에서 빼줘야함.
		}
		System.out.print("<");
		for (int i = 0; i < nList.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(nList[i]);
		}
		System.out.println(">");
	}

}
