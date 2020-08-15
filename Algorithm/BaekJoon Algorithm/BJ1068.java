import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1068 {

	static int[] tree;
	static ArrayList<Integer> list[];

	static int delete;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		tree = new int[n];
		list = new ArrayList[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		int root = 0;
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(tokenizer.nextToken());
			if (tree[i] != -1)
				list[tree[i]].add(i);
			else
				root = i;
		}

		delete = Integer.parseInt(reader.readLine());
		tree[delete] = -1;
		list[delete].clear();

		for (int i = 0; i < list.length; i++) {
			if (list[i].contains(delete))
				list[i].remove(new Integer(delete));
		}
		if (delete == root)
			System.out.println(0);
		else
			System.out.println(BFS(root));
	}

	static int BFS(int root) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);

		int leaf = 0;
		while (!q.isEmpty()) {
			int parent = q.poll();
			if (delete == parent)
				continue;
			if (list[parent].isEmpty())
				leaf++;
			else
				for (int i = 0; i < tree.length; i++) {
					if (tree[i] == parent) {
						q.add(i);
					}
				}
		}
		return leaf;
	}

}
