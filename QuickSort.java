import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int []arr = { -9 , 78 , 0 , 23 , -567 , 70};
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

   public static void quickSort(int [] arr , int left , int right){
       int l  = left; // 左下标
       int r = right; // 右下标
       int temp = 0;
       //pivot  中轴值
       int pivot =  arr[(left + right) / 2];
       //while 循环的目的是 让 比pivot 值小的数 放到左边
       // 比pivot 的值大的数放到右边
       while (l < r){
            // 在pivot 的左边一直找 ， 找到大于等于pivot的值，才退出
           while (arr[l] < pivot){
               l += 1;
           }
           // 在pivot的右边一直找 ， 找到小于等于pivot的值 ， 才退出
           while (arr[r] > pivot){
               r -= 1;
           }

           // 如果 l >= r 说明pivot 的左右两边的值，
           // 左边已经全都是小于等于pivot的值了 ， 右边全都是大于等于pivot的值
           if (l >= r){
               break;
           }

          // 交换
          temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;

         // 如果交换完后发现  arr[l] == pivot值 ？
           // r-- ，向前移
           if (arr[l] == pivot){
               r -= 1;
           }
        // 如果交换完后 ， 发现arr[r] == pivot
        // l++ ,向后移

           if (arr[r] == pivot){
               l +=1;
           }
       }

       // 如果 l == r , 必须l++ , r-- ， 否则会栈溢出
         if (l == r){
             l += 1;
             r -= 1;
         }

         // 向左递归
       if (left < r){
           quickSort(arr, left , r);
       }
        // 向右递归
       if (right > l){
           quickSort(arr , l ,right);
       }


    }

}


