package DSA_Kodnest;

import java.util.*;
public class Stack_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,2,3,4,5,6,7,8};
		Stack<Integer> st = new Stack<>();
		int top = -1;
		int size = 4;
		///// Adding / push elements in stack
		for(int i=0;i<arr.length;i++) {
			if(top==size-1) {
				break;
			}
			else {
				top += 1; 
				st.push(arr[i]);
			}
		}
	///// Delete / pop elements in stack
		while(top!=-1) {
			int elem = st.get(top);
			System.out.println("Element has been deleted is "+elem);
			top--;
		}
		System.out.println(st.size());
	}
}
