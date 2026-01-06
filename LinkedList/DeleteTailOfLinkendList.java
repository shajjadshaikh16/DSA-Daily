class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
        data = d;
        next = null;
    }
}
public class DeleteTailOfLinkendList {
    private static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static Node arrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        // Create an array
        int[] arr = {2, 5, 8, 7};
        Node head = arrayToLinkedList(arr);
        head = deleteTailElement(head);
        print(head);
    }
    private static Node deleteTailElement(Node head){
        if(head == null) return null; // Empty list
        Node temp = head;
        while(temp.next.next !=null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
}
