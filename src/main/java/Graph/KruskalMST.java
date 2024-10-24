package Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskalMST {

    public static class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge o1,Edge o2){
            return o1.weight-o2.weight;
        }
    }

    public static class UnionFind{}

    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind = new UnionFind();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        Set<Edge> result = new HashSet<>();

        for(Edge edge:graph.edges){
            priorityQueue.add(edge);
        }
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from,edge.to)){
                result.add(edge);
                unionFind.union(edge.from,edge.to);
            }
        }
        return result;
    }

}
