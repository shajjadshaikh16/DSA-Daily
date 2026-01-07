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
public class ReverseDLL {
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
     private static Node insertAtTailofDLL(Node head,int val){
        Node curr =head;
        while(curr.next!=null) curr = curr.next;
        Node newTail = new Node(val,null,curr);
        curr.next = newTail;
        return head;
    }
    private static Node insertBeforeTailofDLL(Node head,int val){
        if(head == null) return new Node(val);
        if(head.next == null){
            return insertAtHeadofDLL(head,val);
        }
        Node curr =head;
        while(curr.next.next!=null) curr = curr.next;
        Node tail = curr.next;
        Node newTail = new Node(val,tail,curr);
        
        curr.next = newTail;
        tail.back = newTail;
        return head; 
   }
   private static Node insertBeforeKthElementofDLL(Node head,int val,int k){
        int cnt = 0;
        Node curr = head;
        while(curr.next != null){
            cnt++;
            if(cnt == k ){
                break;
            }
            curr = curr.next;

        }
        Node prev = curr.back;
        Node temp = new Node(val,curr,prev);
        prev.next = temp;
        curr.back = temp;

        return head;
    }
     private static Node insertBeforeNodeofDLL(Node head,int val,int k){
        Node curr = head;
        while(curr.next != null){
            if(curr.data == k){
                break;
            }
            curr=curr.next;
        }
        Node prev = curr.back;
        Node temp = new Node(val,curr,prev);
        prev.next = temp;
        temp.next = curr;
        return head;
    }
    public static void main(String[] args) {
        // Create an array
        int[] arr = {5,4,3,2,1};
        Node head = arrayToDDLinkedList(arr);
        int k = 3;
        int val = 6;
        head = reverseDLL(head);
        print(head);
    }
   private static Node reverseDLL(Node head){
    Node curr = head;
    Node prev = null;
    while(curr != null){
        prev = curr.back;
        curr.back = curr.next;
        curr.next = prev;
        curr=curr.back;
    }
    return prev.back;
   }
}
