package DSA_Kodnest;

public class LinkedList_01 {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		LinkedList.Node newnode = ll.new Node();
		newnode.data = 10;
		newnode.link = null;
		ll.first = newnode;
	}
}
class LinkedList{
	class Node{
		int data;
		Node link;
	}
	Node first;
}