import java.util.Scanner;
class ArrayStack {
    
    private int top;
    private int maxSize;
    private Object[] stackArray;
    
    // �迭 ���� ����,  ������ �ִ� ũ��� ����
    public ArrayStack(int maxSize){
        
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1;
    }
    
    // ������ ����ִ��� üũ
    public boolean empty(){
        return (top == -1);
    }
    
    // ������ ��á���� üũ
    public boolean full(){
        return (top == maxSize-1);
    }
    
    // ���ÿ� item �Է�
    public void push(Object item){
        
        if(full()) throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
        
        stackArray[++top] = item;
    }
    
    // ������ ���� ���� ������ ��ȯ
    public Object peek(){
        
        if(empty()) throw new ArrayIndexOutOfBoundsException(top);
        
        return stackArray[top];
    }
    
    // ������ ���� ���� ������ ����
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
				if(a.empty()||'('!=(char)a.pop()) //������ ��������� pop�� �������ϰ� ')'�� �����ϴ� ���� ������ false��
					return false;
			}
		}
		if(!a.empty()) //push pop�� ������ ���� ������� -> ������� ���� ��� false
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
