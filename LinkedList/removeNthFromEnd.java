class Node{
    int data;
    Node next;
    Node back;
    Node(int data1,Node next1,Node back1){
        this.data= data1;
        this.next = next1;
        this.back = back1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
public class removeNthFromEnd {
     private static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    private static Node arrayToDDLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i =1;i<arr.length;i++){
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static void main(String[] args) {
        // Create an array
        int[] arr = {5,4,3,2,1};
        Node head = arrayToDDLinkedList(arr);
        int n=2;
        head= removeNthFromEnd(head,n);
        print(head);
    }
     public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // move both until fast is at last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete nth from end
        slow.next = slow.next.next;

        return dummy.next;
    }
}
