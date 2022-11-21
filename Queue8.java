public class Queue8 {

    // 定义一个max表示有多少个皇后
    int max  = 8;
    // 定义数组array ， 保存皇后放置位置的结果， 比如 arr = {}
     int [] arr = new int [max];
     public  static void main (String []args){

     }

     // 编写一个方法， 放置第n个皇后
    // check是每一次递归时， 进入到check中都有for ， 因此会有回溯
    private void  check(int n){
         if (n == max){ // 这时n == 8
              print();
              return;
         }

        // 依次放入皇后 ， 并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前的皇后n ， 放到该行的第1列
          arr[n] = 1;
          // 判断当放置第n 个皇后到i列时， 是否冲突
        if (judge (n)){ // 不冲突
              // 接着放n+1个皇后， 即开始递归
             check( n+ 1);

        }
         // 如果冲突， 就继续执行arr[n] = i , 即将第n个皇后， 放置在本行的后移一个位置

        }
     }

     // 当我们放着第n个皇后
     //查看当我们放置第n个皇后， 就去检测该皇后是否和前面已经摆放好的皇后冲突
    public boolean judge (int n ){
        for (int i = 0; i < n ; i++) {
            // arr [i] == arr[n] 是判断第n个皇后是否和前面 n-1 个皇后在同一列
            // Math.abs 用来判断是否在同一斜线上 (难理解)
            // 没必要判断行是否相等， 行在不断的递增
            if (arr [i] == arr[n] || Math.abs(n-i) == Math.abs (arr[n] - arr[i])){
                return false;
            }
        }
  return  true;
    }

     // 写一个方法， 可以将 皇后摆放的位置输出
    private  void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }
}
