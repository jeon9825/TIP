import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BJ4673 {
	static int d(int n) {
		int n5 = n / 10000;
		int n4 = n % 10000 / 1000;
		int n3 = n % 1000 / 100;
		int n2 = n % 100 / 10;
		int n1 = n % 10;
		return n + n1 + n2 + n3 + n4 + n5;
	}

	public static void main(String[] args) {
//		System.out.println(d(33));
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10000; i++) {
			list.add(i + 1);
		}

		Iterator<Integer> it = list.iterator();
		int n = 1;
		int dn = 1;

		List<Integer> list2 = new ArrayList<>();

		while (n<=10000) {
			dn = d(dn);
			
			if (list.contains(dn)&&!list2.contains(dn)) {
				list2.add((Integer)dn);
			}
			if (dn > 10000) {
				dn = ++n;
			}
			
		}

		list.removeAll(list2);
		for(int value : list){
		    System.out.println(value);
		}
	}
}
