package LinkedArrayList;

import static LinkedArrayList.LeetCode2.printList;

/**
 * 排序链表，时间复杂度O(nlogn)
 */
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //找到链表的中点
        ListNode middle = findMidleNode(head);
        //System.out.println("middle:"+middle.val);
        ListNode rightHead = middle.next;
        middle.next = null;
        //分别对左右链表进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        //合并两个有序链表
        return mergeTwoList(left,right);
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left!=null && right!=null){
            if(left.val<right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left!=null){
            cur.next = left;
        }
        if (right!=null){
            cur.next = right;
        }
        return dummy.next;
    }

    // 1 2 3 4 5
    private ListNode findMidleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LeetCode148 leetCode148 = new LeetCode148();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        printList(leetCode148.sortList(head));
    }
}
