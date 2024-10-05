package LinkedArrayList.Reverse;


class DoublyListNode{
    int val;
    DoublyListNode pre;
    DoublyListNode next;

    DoublyListNode(int val){
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}

public class DoublyLinkedListReversal {
    public static DoublyListNode reverseDoublyList(DoublyListNode head){
        DoublyListNode pre = null;
        DoublyListNode current  = head;
        DoublyListNode next = null;

        while (current!=null){
            next = current.next;
            current.next = pre;
            current.pre = next;

            pre = current;
            current = next;
        }
        return pre;
    }

    public static void printDoublyList(DoublyListNode head) {
        DoublyListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 创建双向链表
        DoublyListNode head = new DoublyListNode(1);
        DoublyListNode node2 = new DoublyListNode(2);
        DoublyListNode node3 = new DoublyListNode(3);
        DoublyListNode node4 = new DoublyListNode(4);

        head.next = node2;
        node2.pre = head;
        node2.next = node3;
        node3.pre = node2;
        node3.next = node4;
        node4.pre = node3;

        System.out.println("Original Doubly List:");
        printDoublyList(head);

        // 反转链表
        DoublyListNode reversedHead = reverseDoublyList(head);

        System.out.println("Reversed Doubly List:");
        printDoublyList(reversedHead);
    }

}
