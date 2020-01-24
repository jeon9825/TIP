import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ArrayStack {

	private int top;
	private int maxSize;
	private Object[] stackArray;

	// 배열 스택 생성, 스택의 최대 크기로 생성
	public ArrayStack(int maxSize) {

		this.maxSize = maxSize;
		this.stackArray = new Object[maxSize];
		this.top = -1;
	}

	// 스택이 비어있는지 체크
	public boolean empty() {
		return (top == -1);
	}

	// 스택이 꽉찼는지 체크
	public boolean full() {
		return (top == maxSize - 1);
	}

	// 스택에 item 입력
	public void push(Object item) {

		if (full())
			throw new ArrayIndexOutOfBoundsException((top + 1) + ">=" + maxSize);

		stackArray[++top] = item;
	}

	// 스택의 가장 위의 데이터 반환
	public Object peek() {

		if (empty())
			throw new ArrayIndexOutOfBoundsException(top);

		return stackArray[top];
	}

	// 스택의 가장 위의 데이터 제거
	public Object pop() {

		Object item = peek();

		top--;

		return item;
	}

}

public class BJ4949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			boolean yesno = false;
			String s = reader.readLine();
			if (s.equals("."))
				break;
//			String pec = s.replaceAll("[^\\[\\]\\(\\)]+", "");// 괄호 제외 문자 parentheses exclusion character
			String[] arr = s.replaceAll("[^\\[\\]\\(\\)]+", "").split("");
			ArrayStack arrstack = new ArrayStack(arr.length);
			// System.out.println(Arrays.toString(arr));

			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("[") || arr[i].equals("(")) {
					arrstack.push(arr[i]);
				} else if (arr[i].equals("]")) {
					if (arrstack.empty() || !arrstack.empty() && !arrstack.pop().equals("[")) {
						yesno = false;
						break;
					} else {
						yesno = true;
					}
				} else if (arr[i].equals(")")) {
					if (arrstack.empty() || !arrstack.empty() && !arrstack.pop().equals("(")) {
						yesno = false;
						break;
					} else {
						yesno = true;
					}
				}
			}
			if(arrstack.empty())
				yesno=true;
			
			if (yesno)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
