package binaryTree;

public class GetSuccessorNode {

    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int v)
        {
            val = v;
        }
    }

    public static Node getSuccessorNode(Node node)
    {
        if(node == null){
            return node;
        }
        //node右子树存在，它的后继节点就是右子树的最左节点
        if(node.right!= null){
            return getLeftMost(node.right);
        }else{
            //无右子树，向上寻找
            Node parent = node.parent;
            while (parent!=null && parent.left!=node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    public static Node getLeftMost(Node node)
    {
        if(node == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
