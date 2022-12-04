import java.lang.reflect.Array;
import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {

    }


// 插入排序

    public static void insertSort(int[] arr) {
      int insertVal = 0;
      int insertIndex = 0;

      for (int i = 1; i< arr.length; i++){
          insertIndex = i -1 ;
          insertVal = arr[i];

       while (insertIndex >= 0 && insertVal < arr[insertIndex]){
           arr[insertIndex + 1] = arr[insertIndex];
           insertIndex--;
       }
       arr[insertIndex + 1] = insertVal;
      }

      // 使用逐步推导的方法来讲解
        // 第一轮{101 , 34 , 119 , 1}  -- >  {34 , 101 , 119 ,1}

        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1; // 当前arr[]的前面的数

        // 给insertVal 找到插入的位置
        // 说明
        // insertIndex >= 0    保证在给insertVal 找位置时不越界
        //3. 将 arr [insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
       //  当退出了while循环时， 说明插入的位置已经找到， insertIndex +1 ；
        arr[insertIndex +1] = insertVal;

        System.out.println("第1轮插入");
        System.out.println(Arrays.toString(arr));

         insertVal = arr[2];
         insertIndex = 2 -1;

         while (insertIndex >= 0&& insertVal <arr[insertIndex]){
             arr[insertIndex +1] = arr[insertIndex];
             insertIndex--;
         }

        arr[insertIndex +1 ] = insertVal;
        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));


        insertVal = arr[3];
        insertIndex = 3 -1;

        while (insertIndex >= 0&& insertVal <arr[insertIndex]){
            arr[insertIndex +1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex +1 ] = insertVal;
        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));

 }

}
