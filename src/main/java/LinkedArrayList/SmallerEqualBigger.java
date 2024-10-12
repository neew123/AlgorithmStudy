package LinkedArrayList;

/**
 * 给定一个单链表的头节点head，节点的值类型是整型，再给定一个整数pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是小于pivot的节点，
 * 中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
 */
public class SmallerEqualBigger {
    public static class Node{
        public int value;
        public Node next;
        public Node(int val)
        {
            this.value = val;
        }
    }

    public static Node listPartition(Node head,int pivot){
        Node smallHead = null;
        Node smallTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node bigHead = null;
        Node bigTail = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(smallHead == null){
                    smallHead = head;
                    smallTail = head;
                }else {
                    smallTail.next = head;
                    smallTail = head;
                }
            }else if(head.value == pivot){
                if(equalHead == null){
                    equalHead = head;
                    equalTail = head;
                }else {
                    equalTail.next = head;
                    equalTail = head;
                }
            }else {
                if(bigHead == null){
                    bigHead = head;
                    bigTail = head;
                }else {
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            head = next;
        }
        //如果有小于区域
        if(smallTail!=null){
            smallTail.next = equalHead;
            equalTail = (equalTail == null)?smallTail:equalTail;
        }
        //找出连大于区域的头
        if(equalTail != null){
            equalTail.next = bigHead;
        }
        return smallHead!=null?smallHead:(equalHead!=null?equalHead:bigHead);
    }

}
