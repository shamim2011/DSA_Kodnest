package DSA_Kodnest;

import java.util.Scanner;

public class CircularQue_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the stack size ");
		int n =sc.nextInt();
		CircularQ cq = new CircularQ(n);
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
                	cq.push();
                    break;
                case 2:
                	cq.delete();
                    break;
                case 3:
                	cq.display();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    valid = false;
            }
        }
	}
}
class CircularQ{
	int[] s;
	int size;
	int f = 0;
	int r = -1;
	int count = 0;
	Scanner sc = new Scanner(System.in);
	public CircularQ(int n) {
		s = new int[n];
		size = s.length;
	}
	public void push() {
		int elem;
		if(count==size) {
			System.out.println("Push is not possible");
		}
		else {
			r = (r+1)%size;
			elem = sc.nextInt();
			s[r] = elem;
			count++;
		}
	}
	public void delete() {
		if(count==0) {
			System.out.println("Pop is not possible");
		}
		else {
			System.out.println("Delete elements "+s[f]);
			f = (f+1)%size;
			count--;
		}
	}
	public void display() {
		int f1 = f;
		if(count==0) {
			System.out.println("Pop is not possible");
		}
		else {
			for(int i=0;i<count;i++) {
				System.out.print(s[f1]+" ");
				f1 = (f1+1)%size;
			}
			System.out.println();
		}
	}
}