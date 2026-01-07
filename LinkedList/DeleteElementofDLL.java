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
public class DeleteElementofDLL {
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
     private static Node DeleteHeadofDLL(Node head){
        if(head == null) return null;
        Node prev = head;
        head = head.next;

        head.back=null;
        prev.next=null;
        return head;
    }
    private static Node DeleteTailofDLL(Node head){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }
    public static void main(String[] args) {
        // Create an array
        int[] arr = {2,13,6, 5, 8, 7,4,5,6};
        Node head = arrayToDDLinkedList(arr);
        int k = 3;
        int val = 6;
        head = deleteElementofDLL(head,val);
        print(head);
    }
    private static Node deleteElementofDLL(Node head,int val){
        if (head == null) return null;
        Node current = head;
        while (current != null) {
            if (current.data == val) {
                if (current == head) {
                    return DeleteHeadofDLL(head);
                } else {
                    // Node prev = current.back;
                    // Node next = current.next;
                    // prev.next = next;
                    // if (next != null) next.back = prev;
                    // current.next = null;
                    // current.back = null;
                    // return head;
                    Node prev = current.back;
                    Node front = current.next;
                    if(front == null){
                        return DeleteTailofDLL(head);
                    }
                    prev.next = front;
                    front.back = prev;
                    
                }
            }
            current = current.next;
        }
        return head;
    }
}
