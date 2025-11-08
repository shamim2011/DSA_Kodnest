package DSA_Kodnest;

import java.util.*;

public class Queue_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the stack size ");
		int n =sc.nextInt();
		Queue1 que = new Queue1(n);
		boolean valid = true;
		while (valid) {
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
                	que.push();
                    break;

                case 2:
                	que.pop();
                    break;
                case 3:
                	que.display();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    valid = false;
            }
        }
	}
}
class Queue1{
	int[] s;
	int size;
	int r = -1;
	Scanner sc = new Scanner(System.in);
	public Queue1(int n) {
		s = new int[n];
		size = s.length;
	}
	public void push() {
		int elem;
		if(r==size-1) {
			System.out.println("Push is not possible");
		}
		else {
			elem = sc.nextInt();
			r++;
			s[r] = elem;
		}
	}
	public void pop() {
		if(r>size) {
			System.out.println("Pop is not possible");
		}
		else {
			System.out.println("Delete elements "+s[r]);
			r++;
		}
	}
	public void display() {
		if(r>size) {
			System.out.println("not possible to display");
		}
		else {
			for(int i=0;i<size;i++) {
				System.out.println(s[i]);
			}
		}
	}
}