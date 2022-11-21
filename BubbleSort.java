import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};

        // 推导过程
        int temp = 0;
        // 第一趟排序， 就是将最大的数排在最后
        for (int i = 0; i < arr.length - 1 - 0; i++) {
            // 如果前面的数比后面的数大， 就交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // 一个一个往后比， 绝对能比出来一个最大的
        System.out.println("第一次排序后的数组");
        System.out.println(Arrays.toString(arr));


        for (int i = 0; i < arr.length - 1 - 1; i++) {
            // 如果前面的数比后面的数大， 就交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // 一个一个往后比， 绝对能比出来一个最大的
        System.out.println("第2次排序后的数组");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1 - 2; i++) {
            // 如果前面的数比后面的数大， 就交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // 一个一个往后比， 绝对能比出来一个最大的
        System.out.println("第3次排序后的数组");
        System.out.println(Arrays.toString(arr));


        for (int i = 0; i < arr.length - 1 - 3; i++) {
            // 如果前面的数比后面的数大， 就交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // 一个一个往后比， 绝对能比出来一个最大的
        System.out.println("第4次排序后的数组");
        System.out.println(Arrays.toString(arr));


        // 得出结论
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                // 如果前面的数比后面的数大， 就交换
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            // 一个一个往后比， 绝对能比出来一个最大的
            System.out.println("第"  + (j + 1)+ "次排序后的数组");
            System.out.println(Arrays.toString(arr));

        }
    }
}
