class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
        data = d;
        next = null;
    }
}
public class DeleteKthElementofLinkedList {

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

    private static Node deleteKthElement(Node head, int k) {
        if (head == null || k < 1) return head;
        if (k == 1) {
            return head.next;
        }
        int cnt =0;
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next = prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Create an array
        int[] arr = {1,4,6,2, 5, 8, 7};
        Node head = arrayToLinkedList(arr);
        int k = 3; // Example: delete the 3rd element
        head = deleteKthElement(head, k);
        print(head);
    }
}
