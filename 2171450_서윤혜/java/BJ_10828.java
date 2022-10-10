import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10828 {
	private int[] array;
	private int index;
	
	BJ_10828(int i){
		array = new int[i]; //배열생성
		index = 0;
	}
	
	public void push(int i) {
		array[index] = i;
		index += 1;
	}
	
	public int size() {
		return index;
	}
	
	public int empty() {
		if(index <= 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int pop() {//예외처리
		try {
			return array[--index];
		} catch(ArrayIndexOutOfBoundsException e) {
			//array를 10개를 만들었는데 array[100]이나 array[-1]같은 것을 요구했을 경우, 오류가 뜬다.
			index = 0;
			return -1;
		}

	}
	
	public int top() {
		try {
			return array[index - 1];
		} catch(ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
		int i = Integer.parseInt(bf.readLine());
		
		BJ_10828 m = new BJ_10828(i);
		
		for(int n = 0; n < i; n++) {
			String order = bf.readLine();
			String[] orderArr = order.split(" "); //push 1 orderArr[0] = push / orderArr[1] = 1
			//top orderArr[0] = top
			switch(orderArr[0]) {
				case "push":
				m.push(Integer.parseInt(orderArr[1]));
				break;
				
				case "size":
				System.out.println(m.size());
				break;
				
				case "empty":
				System.out.println(m.empty());
				break;
				
				case "pop":
				System.out.println(m.pop());
				break;
		
				case "top":
				System.out.println(m.top());
				break;
			}
		}
	} catch(IOException e) {
			
		}
	}
}
