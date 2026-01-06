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
public class LengthofLinkedList {
    private static Node LengthofLinkedList(int arr[]){
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
        Node head = LengthofLinkedList(arr);
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
       System.out.println("Length of Linked List: " + count);
    }
}