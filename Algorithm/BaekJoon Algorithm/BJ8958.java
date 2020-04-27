import java.util.Scanner;

public class BJ8958 {
	static int countScore(String arr) {
		char[] charArray = arr.toCharArray();
		int oNum = 0;
		int sum = 0;
		for (int j = 0; j < charArray.length; j++) {
			if (charArray[j] == 'O')
				sum += ++oNum;
			else
				oNum = 0;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.next();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(countScore(arr[i]));
		}
	}
}
