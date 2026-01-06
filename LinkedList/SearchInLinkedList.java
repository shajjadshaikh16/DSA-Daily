// Node definition
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SearchInLinkedList {
    Node head;

    // insert at end (helper)
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // search: returns true if key is present
    boolean search(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {   // check current node
                return true;
            }
            curr = curr.next;         // move to next
        }
        return false;                 // not found
    }
    public static void main(String[] args) {
        SearchInLinkedList list = new SearchInLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        int key = 20;
        if (list.search(key)) {
            System.out.println(key + " found in list");
        } else {
            System.out.println(key + " not found in list");
        }
    }
}
