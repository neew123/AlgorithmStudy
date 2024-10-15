package LinkedArrayList;

import java.util.HashMap;

/**
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 *
 * 方法1：利用哈希表记录当前节点和新节点的对应关系。key为原节点，value为新节点
 *
 */
class Node{
    int value;
    Node next;
    Node rand;
    Node(int val){
        this.value = val;
    }
}

public class CopyListWithRand {

    public static Node copyListWithRandByHashMap(Node head){
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Node cur = head;
        while(cur!=null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            //cur -- 老
            //map.get(cur) -- 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
}
