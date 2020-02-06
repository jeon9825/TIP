import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//�׷���(���) Ŭ����
class ArrGraph {
	private int[][] arrGraph;
	boolean[] visit;

	// �׷��� �ʱ�ȭ
	public ArrGraph(int initSize) {
		// �׷��� �ʱ�ȭ
		// put(int x, int y) ���� �ԷµǴ� ������ ���� 0 �̻��� �����̳�
		// �迭�� index�� 0 ���� �����̹Ƿ�
		// ArrayIndexOutOfBoundsException ������ ����
		// ������ ��� ��������� ��� �� size�� 1�� ���Ͽ� �ʱ�ȭ����
		this.arrGraph = new int[initSize + 1][initSize + 1];
		this.visit = new boolean[initSize + 1];
	}

	// �׷��� return
	public int[][] getGraph() {
		return this.arrGraph;
	}

	// �׷��� �߰� (�����)
	public void put(int x, int y) {
		arrGraph[x][y] = arrGraph[y][x] = 1;
	}

	// �׷��� �߰� (�ܹ���)
	public void putSingle(int x, int y) {
		arrGraph[x][y] = 1;
	}

	// �׷��� ��� (�������)
	public void printGraphToAdjArr() {
		for (int i = 0; i < arrGraph.length; i++) {
			for (int j = 0; j < arrGraph[i].length; j++) {
				System.out.print(" " + arrGraph[i][j]);
			}
			System.out.println();
		}
	}

	public void dfs(int i) {
		visit[i] = true;
		for (int j = 1; j < arrGraph[i].length; j++) {
			if (arrGraph[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}

	public int countAdj() {
		int count = 0;

		dfs(1);

		for (int i = 2; i < visit.length; i++) {
			if (visit[i])
				count++;
		}
		return count;
	}
}

public class BJ2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int nCom = Integer.parseInt(reader.readLine());
		int connect = Integer.parseInt(reader.readLine());
		ArrGraph g = new ArrGraph(nCom);

		StringTokenizer tokenizer;
		for (int i = 0; i < connect; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			g.put(x, y);
		}
//		g.printGraphToAdjArr();
		System.out.println(g.countAdj());
	}

}
