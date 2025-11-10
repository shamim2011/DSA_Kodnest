package DSA_Kodnest;
import java.util.*;
public class DoublyLL_01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		LinkedList3 ll = new LinkedList3();
		System.out.println("Enter the number of elemets : ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			ll.insertRear();
		}
		System.out.println("Displaying the inserting all rearEnd elemets : ");
		ll.display();
		System.out.println("Displaying the list in reverse order : ");
		ll.reverseDisplay();
		
		// Insert element in frontend
		ll.insertFront();
		System.out.println("Displaying the inserting all FrontEnd elemets : ");
		ll.display();
		System.out.println("Displaying the list in reverse order : ");
		ll.reverseDisplay();
		
		// Insert element in frontend
		System.out.println("Enter the position where you want to insert:");
		int pos = sc.nextInt();
		ll.insertPosition(pos);
		System.out.println("Displaying the all elemets after insert: ");
		ll.display();
		System.out.println("Displaying the list in reverse order : ");
		ll.reverseDisplay();
		
		// Delete element from front
		ll.deleteFront();
		System.out.println("Displaying the all elemets After front delete: ");
		ll.display();
		System.out.println("Displaying the list in reverse order : ");
		ll.reverseDisplay();
		

		// Delete element from rear
		ll.deleteRear();
		System.out.println("Displaying the all elemets After rear delete: ");
		ll.display();
		System.out.println("Displaying the list in reverse order : ");
		ll.reverseDisplay();
	}
}
class LinkedList3{
	class Node{
		int data;
		Node next;
		Node prev;
	}
	Node first;
	Node tail;
	Scanner sc= new Scanner(System.in);
	
	/// Inserting the element in FrontEnd 
	public void insertFront() { 
		Node newnode = new Node();
		System.out.println("Enter the data for frontend");
		int elem = sc.nextInt();
		newnode.data = elem;
		newnode.next = null;
		newnode.prev = null;
		
		if(first==null) {
			first = newnode;
		}
		newnode.next = first;
		first.prev=newnode;
		first = newnode;
	}
	/// Inserting the element in rearEnd
	public void insertRear() { 
		Node newnode = new Node();
		System.out.println("Enter the data ");
		int elem = sc.nextInt();
		newnode.data = elem;
		newnode.next = null;
		newnode.prev = null;
		
		if(first==null){
			first = newnode;
			return;
		}
		Node temp = first;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newnode;
		newnode.prev=temp;
	}
	/// Inserting the element in Position
	public void insertPosition(int pos) { 
		Node newnode = new Node();
		System.out.println("Enter the data for Insert in position");
		int elem = sc.nextInt();
		newnode.data = elem;
		newnode.next = null;
		newnode.prev = null;
		
		if(pos==1) {
			insertFront();
			return;
		}
		if(first==null) {
			first = newnode;
		}
		Node temp = first;
		for(int i=1;i<pos-1 && temp!=null;i++) {
			temp=temp.next;
		}
		
		// Case 3: Invalid position (too large)
	    if (temp == null) {
	        System.out.println("Position out of range!");
	        return;
	    }

	    // Insert the node
	    newnode.next = temp.next;
	    newnode.prev = temp;

	    // Null check before accessing temp.next.prev
	    if (temp.next != null) {
	        temp.next.prev = newnode;
	    }

	    temp.next = newnode;
	}
	/// Delete elements from FrontEnd 
	public void deleteFront() { 
		if(first.next==null) {
			System.out.println("Delete elements:"+first.data);
			return;
		}
		Node temp = first.next;
		first.next = null;
		temp.prev = null; 
		first = temp;
	}
	/// Delete elements from RearEnd 
	public void deleteRear() { 
		if(first.next==null) {
			System.out.println("List is empty");
			return;
		}
		// Case 1: Only one node
	    if (first.next == null) {
	        System.out.println("Deleted element: " + first.data);
	        first = null;
	        return;
	    }
		Node temp = first;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next = null;
		
//		// Move to previous node
//	    temp.prev.next = null;
//	    temp.prev = null; // clear backward link
	}
	public void display() {
		Node temp=first;
		if (first == null) {
		    System.out.println("List is empty.");
		    return;
		}
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	/// Displaying the element in reverse order
	public void reverseDisplay() {
		Node temp=first;
		if (first == null) {
		    System.out.println("List is empty.");
		    return;
		}
		if(temp.next==null) {
			System.out.println("Elements "+first.data);
			return;
		}
		while(temp.next!=null) {
			temp = temp.next;
		}
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
		System.out.println();
	}
}