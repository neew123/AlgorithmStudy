package LinkedArrayList;

import static LinkedArrayList.LeetCode2.printList;

/**
 * 重排链表：将原链表的左半段和反转后的右半段合并后的结果
 *
 * 1->2->3->4->5
 * 1->5->2->4->3
 */
public class LeetCode143 {
    public void reorderList(ListNode head) {
        //找到中点
        ListNode midNode = findMidleNode(head);
        //System.out.println("midNode:"+midNode.val);
        //断开左右链表
        ListNode rightHead = midNode.next;
        ListNode leftHead = head;
        midNode.next = null;
        //反转右段链表
        rightHead = reverseList(rightHead);
       // printList(rightHead);
        //System.out.println();
        //合并左右链表 1 2 3  5 4
        while (leftHead!=null && rightHead!=null){
            ListNode left = leftHead.next;
            ListNode right = rightHead.next;
            leftHead.next = rightHead;
            rightHead.next = left;

            leftHead = left;
            rightHead = right;
        }

    }

    private ListNode reverseList(ListNode rightHead) {

        ListNode pre = null,current=rightHead,next;
        while (current!=null){
            next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }
        return pre;
    }

    //1 2 3 4 5

    private ListNode findMidleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LeetCode143 leetCode143 = new LeetCode143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        leetCode143.reorderList(head);
        printList(head);
    }
}
