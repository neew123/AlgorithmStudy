package LinkedArrayList;

import static LinkedArrayList.LeetCode2.printList;

/**
 * 两两交换链表中的节点
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp!=null&&temp.next!=null&&temp.next.next!=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }




    public static void main(String[] args) {
        LeetCode24 leetCode24 = new LeetCode24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printList(leetCode24.swapPairs(head));
    }
}
