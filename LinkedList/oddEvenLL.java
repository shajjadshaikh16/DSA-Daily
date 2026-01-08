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
public class oddEvenLL {
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
        head= oddEvenList(head);
        print(head);
    }
      public static Node oddEvenList(Node head) {
        if(head == null || head.next == null)return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
}
}