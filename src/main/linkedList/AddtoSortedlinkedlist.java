package linkedList;


/*Algorithm: 
Let input linked list is sorted in increasing order.

1) If Linked list is empty then make the node as head and return it.
2) If value of the node to be inserted is smaller than value of head node, then insert the node 
   at start and make it head.
3) In a loop, find the appropriate node after which the input node (let 9) is to be inserted. 
   To find the appropriate node start from head, keep moving until you reach a node GN (10 in
   the below diagram) who's value is greater than the input node. The node just before GN is the
   appropriate  node (7).
4) Insert the node (9) after the appropriate node (7) found in step 3.*/

class AddtoSortedlinkedlist
{
    Node head;  // head of list
 
 /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
 
    /* function to insert a new_node in a list. */
    void sortedInsert(Node new_node)
    {
         Node current;
 
         /* Special case for head node */
         if (head == null || head.data >= new_node.data)
         {
            new_node.next = head;
            head = new_node;
         }
         else {
 
            /* Locate the node before point of insertion. */
            current = head;
 
            while (current.next != null &&
                   current.next.data < new_node.data)
                  current = current.next;
 
            new_node.next = current.next;
            current.next = new_node;
         }
     }
 
                  /*Utility functions*/
 
    /* Function to create a node */
    Node newNode(int data)
    {
       Node x = new Node(data);
       return x;
    }
 
     /* Function to print linked list */
     void printList()
     {
         Node temp = head;
         while (temp != null)
         {
            System.out.print(temp.data+" ");
            temp = temp.next;
         }
     }
 
     /* Drier function to test above methods */
     public static void main(String args[])
     {
         LinkedList llist = new LinkedList();
         Node new_node;
         new_node = llist.newNode(5);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(10);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(7);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(3);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(1);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(9);
         llist.sortedInsert(new_node);
         System.out.println("Created Linked List");
         llist.printList();
     }
}