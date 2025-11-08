package DSA_Kodnest;

import java.util.*;
public class Queue_02 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int size = 4;
		int r=-1;
		while(r+1<size) {
			r++;
			que.add(arr[r]);
			if (que.size() > size) {
                que.poll();
            }
		}
		while(!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}
}
