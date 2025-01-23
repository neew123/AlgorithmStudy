package LinkedArrayList;

/**
 * 两数相加
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int carry = 0,mod = 0;
        while(l1!=null || l2!=null){
            int sum = (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+carry;
            carry = sum/10;
            mod = sum%10;
            p.next = new ListNode(mod);
            p = p.next;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }

        if(carry>0)
            p.next = new ListNode(carry);

        return dummyHead.next;
    }

    public static void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList(leetCode2.addTwoNumbers(l1,l2));
        System.out.println();
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        printList(leetCode2.addTwoNumbers(l3,l4));
        System.out.println();
        ListNode l5 = new ListNode(9);
        l5.next = new ListNode(9);
        l5.next.next = new ListNode(9);
        l5.next.next.next = new ListNode(9);
        l5.next.next.next.next = new ListNode(9);
        l5.next.next.next.next.next = new ListNode(9);
        l5.next.next.next.next.next.next = new ListNode(9);
        ListNode l6 = new ListNode(9);
        l6.next = new ListNode(9);
        l6.next.next = new ListNode(9);
        l6.next.next.next = new ListNode(9);
        printList(leetCode2.addTwoNumbers(l5,l6));
    }
}
