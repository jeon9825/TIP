import java.util.Scanner;
class ArrayStack {
    
    private int top;
    private int maxSize;
    private Object[] stackArray;
    
    // 배열 스택 생성,  스택의 최대 크기로 생성
    public ArrayStack(int maxSize){
        
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1;
    }
    
    // 스택이 비어있는지 체크
    public boolean empty(){
        return (top == -1);
    }
    
    // 스택이 꽉찼는지 체크
    public boolean full(){
        return (top == maxSize-1);
    }
    
    // 스택에 item 입력
    public void push(Object item){
        
        if(full()) throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
        
        stackArray[++top] = item;
    }
    
    // 스택의 가장 위의 데이터 반환
    public Object peek(){
        
        if(empty()) throw new ArrayIndexOutOfBoundsException(top);
        
        return stackArray[top];
    }
    
    // 스택의 가장 위의 데이터 제거
    public Object pop(){
        
        Object item = peek();
        
        top--;
        
        return item;
    }

}
public class BJ9012 {
	public static boolean VPS (String s) {
		ArrayStack a = new ArrayStack(50);
		char [] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if(c[i]=='(') { 
				a.push(c[i]);
			}
			else if (c[i]==')') { 
				if(a.empty()||'('!=(char)a.pop()) //스택이 비어있으면 pop를 하지못하고 ')'로 시작하는 것은 무조건 false임
					return false;
			}
		}
		if(!a.empty()) //push pop을 끝내고 나면 비어있음 -> 비어있지 않을 경우 false
			return false;
		return true;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		String [] s = new String [n];
		boolean [] b = new boolean [n];
		for (int i = 0; i < s.length; i++) {
			s[i] = input.next();
		}
		for (int i = 0; i < b.length; i++) {
			b[i]=VPS(s[i]);
		}
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]?"YES":"NO");
		}
	}
}
