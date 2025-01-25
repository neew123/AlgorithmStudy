package LinkedArrayList;

import static LinkedArrayList.LeetCode2.printList;

/**
 * 删除排序链表中的重复元素
 */
public class LeetCode82 {


    // 1 2 3 3 4 4 5
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-101);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next!=null && cur.next.val ==x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        LeetCode82 leetCode82 = new LeetCode82();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        printList(leetCode82.deleteDuplicates(head));
    }
}
