package LinkedArrayList;

import java.util.Stack;

/**给定一个单链表头节点head，请判断该链表是否为回文结构。如果链表长度为N，时间复杂度O(N)，额外空间复杂度O(1)。
* (1) 栈--空间复杂度为O(N)
    使用快慢指针找到链表的中点；
    从头节点开始，将前半部分的节点一次入栈；
    从链表的中点开始，依次与栈中元素进行比较，如果所有元素都相等则链表为回文结构

 **/

public class IsPalindrome {

    public static void findMidNode(ListNode head){
        //根据快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;
        //奇数时slow在中点，偶数时slow在中间靠后位置
//        while (fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        //奇数情况slow在中点，偶数时slow在中间靠前位置
        while (fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("中点："+slow.val);
        //偶数情况判断slow在第一个中点还是第二个中点
        String pos = (slow.val == slow.next.val) ? "第一个中点" : "第二个中点";
        System.out.println(pos);
        System.out.println("fast.val:"+fast.val);

    }
   public static boolean isPalindromeByStack(ListNode head){
       //根据快慢指针找中点
       ListNode slow = head;
       ListNode fast = head;
       Stack<Integer> stack = new Stack<>();
       //前半部分入栈:奇数时slow在中点，偶数时slow在中间靠后位置
       while (fast != null && fast.next != null){
           stack.push(slow.val);
           slow = slow.next;
           fast = fast.next.next;
       }
       //奇数节点，跳过中点
       if(fast != null){
           slow = slow.next;
       }
       //比较后半部分与栈中元素
       while (slow != null){
           int top = stack.pop();
           if(top != slow.val){
               return false;
           }
           slow = slow.next;
       }
       return true;
   }


    public static void main(String[] args) {
        //创建一个偶数回文链表
        System.out.println("偶数回文链表测试：1221");
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println("是否为回文链表：" + isPalindromeByStack(head1));
        //创建一个奇数回文链表
        System.out.println("奇数回文链表测试：12321");
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(1);
        System.out.println("是否为回文链表：" + isPalindromeByStack(head2));
        //找中点
        System.out.println();
        System.out.println("找中点");
        System.out.println("偶数回文链表测试：1221：");
        findMidNode(head1);
        System.out.println("奇数回文链表测试：12321：");
        findMidNode(head2);
    }
}
