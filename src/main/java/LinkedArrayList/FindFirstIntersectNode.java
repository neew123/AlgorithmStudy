package LinkedArrayList;

public class FindFirstIntersectNode {


    //找到链表第一个入环节点，如果无环，返回NULL
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; //n1 -> slow
        Node n2 = head.next.next; //n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; //n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //如果两个链表都无环，返回第一个相交节点，如果不相交，返回null
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        //到最后一个节点
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //如果链表1的节点不等于链表2的节点，一定不相交
        if (cur1 != cur2) {
            return null;
        }
        //n = length1 - length2
        cur1 = n > 0 ? head1 : head2; //长的链表头变成cur1
        cur2 = cur1 == head1 ? head2 : head1;//短的链表头变成cur2
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    //两个有环链表，返回第一个相交节点，如果不相交返回NULL
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n>0?head1:head2;
            cur2 = cur1==head1?head2:head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = cur1.next;
            while (cur1!=loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

     public static Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 ==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 ==null){
            return noLoop(head1,head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
     }
}
