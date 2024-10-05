package LinkedArrayList.Reverse;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class LinkedListReversal {

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;

        while(current!=null){
            next = current.next; //保存下一个节点
            current.next = pre;  //反转指针
            pre = current;      //移动pre
            current = next;     //移动current
        }
        return pre;//返回新的头节点
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 创建单向链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        // 反转链表
        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }

}
