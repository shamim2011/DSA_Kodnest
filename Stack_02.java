package DSA_Kodnest;
import java.util.*;
public class Stack_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the stack size ");
		int n =sc.nextInt();
		Stack1 stack = new Stack1(n);
		while (true) {
            System.out.println("\n--- Stack Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stack.push();
                    break;

                case 2:
                    
                        stack.pop();
                    
                    break;

                case 3:
                    stack.display();
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
	}
}


class Stack1{
	int[] s;
	int size;
	int top = -1;
	Scanner sc = new Scanner(System.in);
	public Stack1(int n) {
		s = new int[n];
		size = s.length;
	}
	public void push() {
		int elem;
		if(top==size-1) {
			System.out.println("Push is not possible");
		}
		else {
			elem = sc.nextInt();
			top++;
			s[top] = elem;
		}
	}
	public void pop() {
		if(top==-1) {
			System.out.println("Pop is not possible");
		}
		else {
			System.out.println("Delete elements "+s[top]);
			top--;
		}
	}
	public void display() {
		if(top==-1) {
			System.out.println("Pop is not possible");
		}
		else {
			for(int i=top;i>=0;i--) {
				System.out.println(s[i]);
			}
		}
	}
}