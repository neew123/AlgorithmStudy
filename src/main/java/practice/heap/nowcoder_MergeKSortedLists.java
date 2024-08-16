package practice.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * 合并K个有序链表
 * https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6
 */
public class nowcoder_MergeKSortedLists {

    public class ListNode{
        public int val;
        public ListNode next;
    }

    public ListNode mergeKList(ArrayList<ListNode> lists){
        // 使用一个小根堆，每次取出最小值
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val-b.val);
        //遍历所有的头
        for(ListNode head:lists){
            if(head!=null){
                heap.add(head);
            }
        }
        //可能遇到的全是空链表
        if(heap.isEmpty()){
            return null;
        }
        //先弹出一个节点作为结果返回的头节点
        ListNode h = heap.poll();
        ListNode pre = h;
        if(pre.next!=null){
            heap.add(pre.next);
        }
        while(!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next!=null){
                heap.add(cur.next);
            }
        }
        return h;
    }
}
