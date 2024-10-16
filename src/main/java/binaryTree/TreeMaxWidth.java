package binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v) {
            this.value = v;
        }
    }

    public static int maxWidth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            maxWidth = Math.max(maxWidth, levelSize); // 更新最大宽度

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return maxWidth;
    }

    //使用HashMap去记录每个节点和相应的层数
    public static int maxWidthUseMap(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node,Integer> levelMap = new HashMap<>();
        levelMap.put(head,1);
        int curLevel = 1;
        int curLevelNodes = 0;//这里为0是出队列的时候才统计当前层的节点
        int maxNodes = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(curNodeLevel == curLevel){
                curLevelNodes++;
            }else {
                maxNodes = Math.max(maxNodes,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;//找到了不属于当前层的节点
            }
            if(cur.left != null){
                queue.add(cur.left);
                levelMap.put(cur.left,curNodeLevel+1);
            }
            if(cur.right != null){
                queue.add(cur.right);
                levelMap.put(cur.right,curNodeLevel+1);
            }
        }
        return maxNodes;
    }


    public static int getMaxWidth2(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Node curEnd = head;
        Node nextLevelEnd = null;
        int curLevelNodes = 0;
        int maxWidth = 0;
        queue.add(head);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            curLevelNodes++;

            if(cur.left != null){
                queue.add(cur.left);
                nextLevelEnd = cur.left;

            }
            if(cur.right != null){
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }

            if(cur == curEnd){
                maxWidth = Math.max(maxWidth,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextLevelEnd;
                nextLevelEnd = null;
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        // 构建示例树
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        // 计算最大宽度

        int width = getMaxWidth2(root);
        System.out.println("树的最大宽度: " + width); // 输出应为 3
    }

}
