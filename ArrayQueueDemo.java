package 复习;/*
   @好好学习，专注点    
   @传说别摆烂 1.0
*/

public class ArrayQueueDemo {

    public static void main(String[] args) {

    }
}

// 使用数组模拟队列  编写一个ArrayQueue类
class ArrayQueue{
    private  int maxSize; // 表示最大容量
    private  int front;
    private  int rear;
    private  int [] arr;// 用于存放数据， 模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new  int[maxSize];
        front = -1;  // 指向队列的  头部的前一个位置
        rear =  -1; // 指向队列的尾部, 指向队列尾部的数据

    }

    // 判断队列是否已满
    public boolean isFull (){
        return  rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return  rear == front;
    }

   // 添加数据到队列
    public void addQueue(int n){

        // 判断队列是否已满
        if (isFull()){
            System.out.println("队列已满， 不能再加入");
            return;
        }
       rear++; // 让rear后移
       arr[rear] = n;
    }
   // 有点类似于敲达摩的游戏
    //获取队列的数据
    public int getQueue(){
        // 判读队列是否为空
        if(isEmpty()){
            // 抛出异常
            throw  new RuntimeException("队列为空， 不能取数据");
        }
         front++;
        return arr[front];
    }
     // 显示队列的所有数据
    public void show(){
        if (isEmpty()){
            System.out.println("队列为空， 没有数据");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]= %d\n",i ,arr[i]);
        }
    }

    // 显示队列的头数据
    public int headQueue(){
        //判读
        if(isEmpty()){
            throw  new RuntimeException("队列为空， 没有数据");
        }
      return  arr[front +1];
    }
}
