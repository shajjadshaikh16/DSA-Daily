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
public class InsertAtTailpfDLL {
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
    private static Node insertAtHeadofDLL(Node head,int val){
        Node newHead = new Node(val,head,null);
        head.back = newHead;
        return newHead;
    }
    public static void main(String[] args) {
        // Create an array
        int[] arr = {2,13,6, 5, 8, 7,4,5,6};
        Node head = arrayToDDLinkedList(arr);
        int k = 3;
        int val = 6;
        head = insertAtTailofDLL(head,val);
        print(head);
    }
    private static Node insertAtTailofDLL(Node head,int val){
        Node curr =head;
        while(curr.next!=null) curr = curr.next;
        Node newTail = new Node(val,null,curr);
        curr.next = newTail;
        return head;
    }

}
