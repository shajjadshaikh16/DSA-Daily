class Node{
      int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
        data = d;
        next = null;
    }
}
public class InsertKbeforexthValue {
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

    private static Node insertKbeforeXthValue(int k, int x, Node head) {
        if (head == null) return null;
        if (head.data == x) {
            Node newNode = new Node(k);
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == x) {
                Node y = new Node(k);
                y.next = temp.next;
                temp.next = y;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Create an array
        int[] arr = {2, 5, 8, 7};
        Node head = arrayToLinkedList(arr);
        int k = 3;
        int x = 8;
        head = insertKbeforeXthValue(k, x, head);
        print(head);
    }
}
