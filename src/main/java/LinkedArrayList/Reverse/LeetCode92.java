package LinkedArrayList.Reverse;

import static LinkedArrayList.Reverse.LinkedListReversal.printList;

/**
 * 反转链表
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = head;
        ListNode leftNode = p, rightNode = p;
        int i = 1;
        while (p!=null){
            if(left == i){
                leftNode = p;
                System.out.println("leftNode:"+leftNode.val);
            }
            if(right == i){
                rightNode = p;
                System.out.println("rightNode:"+rightNode.val);
                break;
            }
            p = p.next;
            i++;
        }
        if(leftNode == rightNode) return head;
        //反转
        p = dummyHead;
        while (p.next!=null && p.next!=leftNode){
            p = p.next;
        }
        p.next = rightNode;
        ListNode pre = leftNode,cur=leftNode.next,next;
        while(pre!=rightNode && cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        leftNode.next = cur;
        return dummyHead.next;
    }



    public static void main(String[] args) {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(leetCode92.reverseBetween(head,2,4));

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(4);
        printList(leetCode92.reverseBetween(head2,1,2));
    }
}
