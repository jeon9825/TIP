import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1991 {
	static Node2[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		list = new Node2[n];
		for (int i = 0; i < n; i++) {
			char[] c = reader.readLine().toCharArray();
			char parent = c[0];
			char left = c[2];
			char right = c[4];
			list[parent - 65] = new Node2(left, right);
		}

		pre(0);
		System.out.println();
		in(0);
		System.out.println();
		post(0);

	}

	static void pre(int n) {
		Node2 node = list[n];
		char left = node.left;
		char right = node.right;

		System.out.print((char) (n + 65));

		if (left != '.') {
			pre(left - 65);
		}
		if (right != '.') {
			pre(right - 65);
		}
	}

	static void in(int n) {
		Node2 node = list[n];
		char left = node.left;
		char right = node.right;

		if (left != '.') {
			in(left - 65);
		}

		System.out.print((char) (n + 65));

		if (right != '.') {
			in(right - 65);
		}
	}

	static void post(int n) {
		Node2 node = list[n];
		char left = node.left;
		char right = node.right;

		if (left != '.') {
			post(left - 65);
		}
		if (right != '.') {
			post(right - 65);
		}

		System.out.print((char) (n + 65));
	}
}

class Node2 {
	char left;
	char right;

	public Node2(char left, char right) {
		this.left = left;
		this.right = right;
	}

}