import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> ve; // 用来存储顶点
    private int[][] edges;  //用来存储 图
    private int edgenum;  // 存储边

    private boolean [] isVisited;
    // 构造器
    public Graph(int n) {
        // 初始化矩阵 和 ve
        edges = new int[n][n];
        ve = new ArrayList<String>(n);
        edgenum = 0;
        isVisited = new  boolean[n];
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

        // 测试一下 ，
        System.out.println("深度遍历dfs");
        graph.dfs();
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

    // 得到节点i的第一个 邻接节点的下标
    public int getFirstNeighbor(int index){
        for (int j = 0 ; j <ve.size(); j++){
            if (edges [index][j] > 0){
                return  j;
            }
        }
     return  -1;
    }

    // 根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1 ,int v2){
        for (int j = v2 +1; j < ve.size(); j++){
            if (edges[v1][j] >0){
                return j;
            }
        }
     return  -1;
    }


    // 深度遍历算法
    // i第一次就是0
    public void dfs(boolean[] isVisited , int i){
        // 首先我们访问该节点，把他输出
        System.out.print(getValueByIndex(i) + "->");
       // 将该节点 设置为已访问
        isVisited[i] = true;
       // 查找节点i的第一个邻接节点w
       int w = getFirstNeighbor(i);
       while (w != -1){  // 找着了第一个邻接节点
           if (!isVisited[w]){
               dfs(isVisited ,w);
           }
           // 如果w节点已经被访问过
           w = getNextNeighbor(i ,w);
       }
    }

    // 如果没找着 ， 没进while
    // 对dfs 进行重载， 遍历所有的节点 ，并进行dfs
    public void dfs (){
        // 遍历所有节点,进行dfs
        for (int i = 0; i < getVerNum(); i++) {
              if (!isVisited[i]){
                  dfs(isVisited,i);
              }
        }
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

