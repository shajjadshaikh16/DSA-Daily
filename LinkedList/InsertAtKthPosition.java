class Node{
      int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
        data = d;
        next = null;
    }
}
public class InsertAtKthPosition {
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
        int val = 1;
        int k = 3;
        head = InsertAtKthPosition(k,val, head);
        print(head);
    }
     private static Node InsertAtKthPosition(int k,int val, Node head){
        if(head==null){
        if(k == 1 ){
            Node newNode = new Node(val);
        }
        return head;
    }
        int cnt = 0;
        Node temp = head;
        while(temp !=null){
            cnt++;
            if(cnt == (k-1)){
                Node x = new Node(val);
                Node y = temp.next;
                temp.next = x;
                x.next = y;
                break;
            }
            temp = temp.next;
        }
         return head;
    }
}
