package DSA_Kodnest;

import java.util.*;

public class LinkedList_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // Scanner object for user input
        LinkedList2 ll = new LinkedList2();    // Create an instance of LinkedList2

        System.out.print("How many elements to insert? ");
        int n = sc.nextInt();                  // Read how many elements user wants to insert

        // Loop to insert n elements RearEnd
        for (int i = 0; i < n; i++) {
            ll.insertRearEnd();                       // Call insert() to add a new node
        }
        /// insert elements FrontEnd
        ll.insertFrontEnd();
        // Display the linked list
        ll.display();
        
        /// insert elements middle
        System.out.println("Enter the position where you want to add ");
        int pos = sc.nextInt();
        ll.insertMiddle(pos);
        ll.display();
        
        /// Removing the data from Front and Rear End
        ll.removeFront();
        ll.display();
        
        ll.removeRear();
        ll.display();
        
        /// Delete elements from middle
        System.out.println("Enter the position where you want to remove ");
        int pos1 = sc.nextInt();
        ll.removeMiddle(pos1);
        ll.display();
        sc.close();                            // Close the scanner to avoid resource leak
    }
}

// Class representing a simple singly linked list
class LinkedList2 {
    
    // Inner class representing a node in the linked list
    class Node {
        int data;      // Data part of the node
        Node link;     // Reference (link) to the next node
    }

    Node first;         // Points to the first node of the linked list
    Scanner sc = new Scanner(System.in);   // Scanner for taking input inside LinkedList2

    // Method to insert a new node at the end of the list
    public void insertRearEnd() {
        Node temp;
        System.out.println("Enter the number: ");
        int elem = sc.nextInt();           // Read the value to be inserted

        Node newnode = new Node();         // Create a new node
        newnode.data = elem;               // Assign data
        newnode.link = null;               // Set link to null (as it will be the last node)

        // If the list is empty, the new node becomes the first node
        if (first == null) {
            first = newnode;
        } 
        // Otherwise, traverse to the last node and attach the new node there
        else {
            temp = first;
            while (temp.link != null) {    // Move till the end of the list
                temp = temp.link;
            }
            temp.link = newnode;           // Link the last node to the new node
        }
    }
    
    /// Inserting the data in Frontend
    public void insertFrontEnd() {
        // Create a new node
        Node newnode = new Node();

        // Ask the user for the number to insert at the front
        System.out.println("Enter the number for frontend: ");
        int elem = sc.nextInt();

        // Assign the entered value to the new node's data field
        newnode.data = elem;

        // Initially set the new node's link to null
        newnode.link = null;

        // If the linked list is empty, make the new node the first node
        if (first == null) {
            first = newnode;
        } 
        // Otherwise, link the new node to the current first node,
        // then make the new node the new first node
        else {
            newnode.link = first;
            first = newnode;
        }
    }
  /// Inserting the data in Frontend with position and element
    public void insertFrontEnd(int elem) {
        // Create a new node
        Node newnode = new Node();

        // Assign the entered value to the new node's data field
        newnode.data = elem;

        // Initially set the new node's link to null
        newnode.link = null;

        // If the linked list is empty, make the new node the first node
        if (first == null) {
            first = newnode;
        } 
        // Otherwise, link the new node to the current first node,
        // then make the new node the new first node
        else {
            newnode.link = first;
            first = newnode;
        }
    }
    /// Inserting the data in middle
    public void insertMiddle(int position) {
        // Create a new node
        Node newnode = new Node();

        // Ask user for the element to insert
        System.out.println("Enter the element to insert in the middle: ");
        int elem = sc.nextInt();

        // Assign the entered element to the new node
        newnode.data = elem;
        newnode.link = null;

        Node temp;

        System.out.println("After inserting the element at position ");

        // Case 1: If the list is empty, make the new node as the first node
        if (first == null) {
            first = newnode;
            return;
        }

        // Case 2: If inserting at the beginning (position 1), call insertFrontEnd()
        if (position == 1) {
            insertFrontEnd(elem);
            return;
        }

        // Case 3: Traverse the list to find the node just before the desired position
        temp = first;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.link;
        }

        // Insert the new node between temp and temp.link
        newnode.link = temp.link;
        temp.link = newnode;
    }

    /// Removed the data from the frontend
    public void removeFront() {
    	System.out.println("Afer removing the Frontend elements ");
        // Check if the linked list is empty
        if (first == null) {
            System.out.println("Empty linkedList: ");
            return;  // Exit the method since there’s nothing to remove
        }
        // only one element present
        if(first.link==null) {
        	first = null;
        	return;
        }
        else {
            // 'temp' will point to the second node (next of first)
            Node temp = first.link;

            // Disconnect the first node from the rest of the list
            first.link = null;

            // Make the second node (temp) the new first node
            first = temp;
        }
    }

    /// Removed the data from the RearEnd
    public void removeRear() {
    	System.out.println("Afer removing the Rearend elements ");
    	if(first == null) {
    		System.out.println("Empty linkedList: ");
    		return;
    	}
    	// If there is only one node, just remove it
        if (first.link == null) {
            first = null;
            return;
        }
        // Otherwise, traverse to the second last node
        Node temp = first;
        while (temp.link.link != null) {
            temp = temp.link;  // Move to the next node
        }

        // Disconnect the last node
        temp.link = null;
    	
    }
    
    /// Inserting the data in middle
    public void removeMiddle(int pos) {
        System.out.println("After remove data:");
        Node temp = first;

        // Case 1: List is empty
        if (first == null) {
            System.out.println("Not possible");  // No nodes to delete
            return;
        }

        // Case 2: Only one element in the list
        else if (first.link == null) {
            first = null;  // Delete the only node
            return;
        }

        // Case 3: Deleting the first node
        else if (pos == 1) {
            removeFront();  // Use existing method to remove first node
            return;
        }

        // Case 4: Traverse to the node *just before* the one to delete
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.link;
        }

        // Now temp points to (pos-1)th node
        Node deleteNode = temp.link;     // Node to be deleted
        temp.link = deleteNode.link;     // Skip over the deleted node
        deleteNode.link = null;          // Disconnect deleted node completely
    }

    
    // Method to display all elements of the linked list
    public void display() {
        // If no nodes are present
        if (first == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = first;                 // Start from the first node
        System.out.print("Linked List: ");
        while (temp != null) {             // Traverse until the end of the list
            System.out.print(temp.data + " ");  // Print data of each node
            temp = temp.link;              // Move to the next node
        }
        System.out.println();              // Print newline at the end
    }
}
