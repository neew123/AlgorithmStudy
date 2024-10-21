package binaryTree;


import java.util.LinkedList;

/**
 * 判断是否为完全二叉树
 */
public class IsCompleteTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int v) {
            val = v;
        }
    }

    public static boolean isCompleteTree(Node head) {
        if(head == null){
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Boolean noCompleteNode = false;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            //判断当前节点是否有右子树而无左子树
            if(cur.left == null && cur.right != null){
                return false;
            }
            //如果出现不完整节点，后续每个节点都必须是叶子节点
            if(noCompleteNode  && (cur.left != null || cur.right != null)){
                return false;
            }

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
            //出现不完整节点
            if(cur.left == null || cur.right == null){
                noCompleteNode = true;
            }
        }
        return true;
    }
}
