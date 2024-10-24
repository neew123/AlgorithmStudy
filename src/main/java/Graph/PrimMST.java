package Graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST {

    public static Set<Edge> primMST(Graph graph){
        //解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for(Node node:graph.nodes.values()){
            if(!set.contains(node)){
                set.add(node);
                for(Edge edge:node.edges){
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for(Edge nextEdge:toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
