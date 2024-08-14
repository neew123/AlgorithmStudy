package binaryTree;

import com.sun.source.tree.Tree;

/**
 * 用递归实现二叉树的三序遍历
 */
public class BinaryTreeTraversalRecurison {


    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v){
            val = v;
        }
    }

    //先序
    public static void preOrder(TreeNode head){
        if(head == null){
            return;
        }
        System.out.println(head.val+" ");
        preOrder(head.left);
        preOrder(head.right);
    }

    //递归基本样子，用来理解递归序
    public static void f(TreeNode head){
        if(head ==null){
            return;
        }
        //1
        f(head.left);
        //2
        f(head.right);
        //3
    }

}



