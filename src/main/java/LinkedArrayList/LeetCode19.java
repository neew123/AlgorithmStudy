package LinkedArrayList;

import static LinkedArrayList.LeetCode2.printList;

/**
 * 删除链表的倒数第N个节点
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (n>0){
            fast = fast.next;
            n--;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode19 leetCode19 = new LeetCode19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(leetCode19.removeNthFromEnd(head,2));
    }
}
