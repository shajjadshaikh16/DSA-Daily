class Node{
    int data;
    Node next;
    Node(int data1,Node next1){
        this.data= data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class TraverseInLinkedList {
    private static Node TraverseInLinkedList(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
    }
    return head;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10,12};
        Node head = TraverseInLinkedList(arr);
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
    }
}