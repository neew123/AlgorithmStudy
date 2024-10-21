package binaryTree;


import java.util.HashMap;

/**
 * 找二叉树两个节点的最近公共祖先
 * 几种可能情况：
 *  （1）O1是O2的祖先、O2是O1的祖先
 *  （2）O1和O2不互为最低公共祖先，向上汇聚才能找到最低公共祖先
 */
public class LowestCommonAncestor {

    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(int v)
        {
            val = v;
        }
    }

    public static Node lowestCommonAncestor(Node head, Node o1, Node o2)
    {
        if(head == null || head == o1 || head == o2){
            return head;
        }
        Node left = lowestCommonAncestor(head.left,o1,o2);
        Node right = lowestCommonAncestor(head.right,o1,o2);
        if(left != null && right != null){
            return head;
        }
        return left != null ? left : right;
    }

}
