import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> ve; // 用来存储顶点
    private int[][] edges;  //用来存储 图
    private int edgenum;  // 存储边

    // 构造器
    public Graph(int n) {
        // 初始化矩阵 和 ve
        edges = new int[n][n];
        ve = new ArrayList<String>(n);
        edgenum = 0;
    }

    public static void main(String[] args) {
        // 测试图是否创建正确
        int n = 5; // 节点个数
        String vet[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        // 循环添加顶点
        for (String vex : vet) {
            graph.insertVex(vex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);

        graph.showGraph();
    }


    // 插入节点
    public void insertVex(String vertex) {
        ve.add(vertex);
    }

    //  添加边
    public void addEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgenum++;
    }

    //返回节点的个数
    public int getVerNum() {
        return ve.size();
    }

    // 返回边的个数
    public int getEdgenum() {
        return edgenum;
    }

    // 返回节点i 对应的数据
    public String getValueByIndex(int i) {
        return ve.get(i);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

}

