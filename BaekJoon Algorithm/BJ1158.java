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
		int[] nList = new int[N]; // �����Ǵ� ������� nList�� ����

		int j = K - 1; // ������ �ε��� j

		for (int i = 0; i < nList.length; i++) { // �ε��� i�� ������ ���� nList�� ä��
			if (!(0 <= j && j < list.size())) { // �ε��� j�� ����� list�� ũ�⸦ �Ѿ��
				j = j % list.size(); // �ε��� j�� ����
			}
			nList[i] = list.remove(j);
			j = j + K - 1; // -1�� �ϴ� ����: ��� ������ ���� �ε������� �������.
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
