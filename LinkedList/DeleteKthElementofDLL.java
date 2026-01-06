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
public class DeleteKthElementofDLL {
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
        int[] arr = {2, 5, 8, 7};
        Node head = arrayToDDLinkedList(arr);
        int k = 3;
        int val = 100;
        head = deleteKthElementofDLL(head,k,val);
        print(head);
    }
    private static Node deleteKthElementofDLL(Node head,int k,int val){
        if(head==null) return null;
        int cnt = 0;
        Node knode = head;
       
        while(knode.next != null){
            cnt++;
            if(cnt==k){
                break;
            }
            knode = knode.next;
        }
        Node prev = knode.back;
        Node front = knode.next;
        if(prev==null || front==null) return null;
        else if(prev==null) return DeleteHeadofDLL(head);
        else if(front==null) return DeleteTailofDLL(head);
        prev.next = front;
        front.back = prev;
        knode.next = knode.back = null;

        return head;
    }
}
