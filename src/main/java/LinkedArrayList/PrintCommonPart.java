package LinkedArrayList;


/**
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。如果两个链表的长度之和为N，时间复杂度为O(N)，额外空间复杂度要求为O(1)
 *
 */

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class PrintCommonPart {


    public static void printCommandPart(ListNode head1,ListNode head2){
        ListNode curs1 = head1;
        ListNode curs2 = head2;
        while (curs1 != null && curs2 != null){
            if(curs1.val < curs2.val){
                curs1 = curs1.next;
            }else if(curs1.val > curs2.val){
                curs2 = curs2.next;
            }else {
                System.out.println(curs1.val+" ");
                curs2 = curs2.next;
                curs1 = curs1.next;
            }
        }

    }

}
