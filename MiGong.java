public class MiGong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int [][] map = new int[8][7]; // 8 行7 列
        // 使用1 表示墙
        // 上下全部设置为1
        for (int i = 0; i < 7; i++) {
             map[0][i] = 1;
             map[7][i] = 1;
        }

         // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i] [0] = 1;
            map[i] [6] = 1;
        }

        // 设置挡板，
        map [3][1] = 1;
        map [3][2] = 1;

        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 使用递归回溯来个小球找路
    /*   1.map 表示地图
         2.i ， j 表示从地图的哪个位置出发(1 , 1)
    *    3.如果小球能走到 map[6] [5] 位置， 说明路已经找到
         4.约定 ： 当map[i] [j] 0表示该点没有走过  当为1 表示墙  2 表示通路，可以走
           3表示该点已经走过，但是走不通
         5.在走迷宫时， 需要确定一个策略 ， 下- 》 右 - 》 上  -》 左
           如果该点走不通，再回溯
         6.如果找到通路 ，返回true ，找不到返回false
    * */
        public  static  boolean setWay (int [][] map, int i, int j) {
            if (map[6][5] == 2) {  // 通路已经找到
                return true;
            } else {
                if (map[i][j] == 0) { // 如果当前这个点还没有走过
                    // 按照策略
                    map[i][j] = 2;
                    if (setWay(map, i + 1, j)) {
                        return true;
                    } else if (setWay(map, i, j + 1)) {
                        return true;
                    } else if (setWay(map, i - 1, j)) {
                        return true;
                    } else if (setWay(map, i, j - 1)) {
                        return true;
                    } else {
                        // 说明该点就是走不通
                        map[i][j] = 3;
                        return false;
                    }
                } else {   // 如果是map[i][j] != 0 , 可能是1 ， 2 ， 3
                    return false;
                }
            }
        }
}
