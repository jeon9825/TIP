import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(reader.readLine());
			if (a == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(a);
			}
		}
	}

//  시간초과 발생
//	static void swap(ArrayList<Integer> list, int i, int j) {
//		int tmp = list.get(i);
//		list.set(i, list.get(j));
//		list.set(j, tmp);
//	}
//
//	static void buildHeap(ArrayList<Integer> list) {
//		int end = list.size() - 1;
//		for (int i = end / 2; i >= 0; i--) {
//			heapify(list, i, end);
//		}
//	}
//
//	static void heapify(ArrayList<Integer> list, int k, int end) {
//		int left = 2 * k + 1, right = 2 * k + 2;
//		int smaller;
//		if (right <= end)
//			smaller = (list.get(left) < list.get(right)) ? left : right;
//		else if (left <= end)
//			smaller = left;
//		else
//			return;
//		if (list.get(smaller) < list.get(k)) {
//			swap(list, smaller, k);
//			heapify(list, smaller, end);
//		}
//	}
//
//	static void heapSort(ArrayList<Integer> list) {
//		buildHeap(list);
//		for (int end = list.size() - 1; end >= 1; end--) {
//			swap(list, 0, end);
//			heapify(list, 0, end - 1);
//		}
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(reader.readLine());
//		ArrayList<Integer> list = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			int a = Integer.parseInt(reader.readLine());
//			if (a == 0) {
//				if (list.isEmpty())
//					System.out.println(0);
//				else {
//					System.out.println(list.get(0));
//					list.remove(0);
//				}
//			} else {
//				list.add(a);
//				heapSort(list);
//			}
//		}
//	}
}
