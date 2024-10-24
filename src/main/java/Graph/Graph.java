package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,Node> nodes; //点对应的编号和实际结构
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
