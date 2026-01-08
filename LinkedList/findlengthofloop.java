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
public class findlengthofloop {
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
    private static boolean detectLoopLL(Node head){
        if(head==null || head.next ==null) return false;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
     private static Node detectLoopLL2(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // Create an array
        int[] arr = {5,4,3,2,1};
        Node head = arrayToDDLinkedList(arr);
        int length;
        length= findlengthofloop(head);
        print(head);
    }
     private static int findlengthofloop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int len = 1;
                while(slow!=fast){
                    len++;
                    slow=slow.next;
                }
                return len;
            }
        }
        return 0;
    }
}
