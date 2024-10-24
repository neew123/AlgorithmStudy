package Graph;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;//入度
    public int out;
    public ArrayList<Node> nexts;  //由当前点发散出去的相邻点
    public ArrayList<Edge> edges; //当前点发散出去的边

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
