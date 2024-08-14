package binaryTree;


import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * (1) 用栈实现树的遍历
 */
public class BinaryTreeStackComplete {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v){
            val = v;
        }
    }

    //先序 中左右
    public static void preOrder(TreeNode head){
      if(head!=null){
          Stack<TreeNode> stack = new Stack<>();
          stack.push(head);
          while(!stack.isEmpty()){
              head = stack.pop();
              System.out.print(head.val+" ");
              if(head.right!=null){
                  stack.push(head.right);
              }
              if(head.left!=null){
                  stack.push(head.left);
              }
          }
      }
        System.out.println();
    }

    //后序 左右中，---> 中右左的反序，用两个栈实现
    public static void postOrderTwoStack(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                collect.push(head);
                if(head.left!=null ){
                    stack.push(head.left);
                }
                if (head.right!=null){
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()){
                System.out.print(collect.pop().val+" ");
            }
        }
        System.out.println();
    }

    //左右中，用一个栈实现后序
    public static void postOrderOneStack(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            //如果始终没有打印过节点，head就一直是头节点
            //一旦打印过节点，head就变成打印节点
            //之后h的含义：上一次的打印节点
            while (!stack.isEmpty()){
                TreeNode cur = stack.peek();
                if(cur.left!=null &&
                  cur.left!=head && cur.right!=head){
                    // 有左树且左树没被处理过
                    stack.push(cur.left);
                }else if(cur.right!=null && cur.right!=head){
                    //有右树且右树没处理过
                    stack.push(cur.right);
                }else {
                    System.out.print(cur.val+" ");
                    head = stack.pop();
                }
            }
        }
        System.out.println();
    }


    //中序 左中右
    //（1）子树左边界进栈、栈弹出节点打印，节点右树重复1、没子树且栈为空
    public static void inOrder(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack = new Stack<>();
             while (!stack.isEmpty()||head!=null){
                  if(head!=null){//子树不为空
                        stack.push(head);
                        head=head.left;
                  }else {
                     head = stack.pop();
                     System.out.print(head.val+" ");
                     head = head.right;
                  }
             }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println("先序遍历非递归版");
        preOrder(head);
        System.out.println("中序遍历非递归");
        inOrder(head);
        System.out.println("后序遍历--两个栈");
        postOrderTwoStack(head);
        System.out.println("后序遍历--一个栈");
        postOrderOneStack(head);
    }

    //leetcode 144 [medium left right]
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode p = stack.pop();
            res.add(p.val);
            if(p.right!=null){
               stack.push(p.right);
            }
            if(p.left!=null){
               stack.push(p.left);
            }
        }
        return res;
    }

    //[left medium right]
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty()||root!=null){
                if(root!=null){
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }

    //[left right medium]
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode peek = stack.peek();
                if(peek.left!=null&&peek.left!=root&&peek.right!=root){
                    stack.push(peek.left);
                }else if(peek.right!=null&&peek.right!=root){
                    stack.push(peek.right);
                }else {
                    root = stack.pop();
                    res.add(root.val);
                }
            }
        }
        return res;
    }
}
