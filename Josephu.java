import jdk.internal.org.objectweb.asm.util.CheckSignatureAdapter;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(28);
        circleSingleLinkedList.showBoy();

        // 测试一下出圈
        //circleSingleLinkedList.countBoy(1 , 2 ,5);
        circleSingleLinkedList.countBoy(1,3,28);
    }
}


//  创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first节点， 当前没有编号
    private Boy first = null;  // 全局变量first

    // 添加小孩节点， 构建成一个环形的链表
    public void addBoy(int nums) {
        // nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        //   使用for来创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号 ， 创建小孩节点
            Boy boy = new Boy(i); // 传编号
            // 如果是第一个小孩
          if (i == 1){
              first = boy;
              first.setNext(first); // 自己和自己构成环
              curBoy = first;  // 让cruBoy 指向第一个小孩
          }else {
              curBoy.setNext(boy);
              boy.setNext(first);
              curBoy =boy;
          }
        }// 这里for结束
    }
    // 遍历当前的环形链表
    public  void  showBoy(){
        // 判断链表是否为空
        if (first == null){
            System.out.println("没有任何小孩~");
            return;
        }
      // 因为first不能动， 因此我们仍然使用一个辅助指针遍历
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d\n" , curBoy.getNo());
         if (curBoy.getNext() == first){
           break;  // 是个环， 指向了 first就会结束
         }
            curBoy = curBoy.getNext(); // curBoy后移
        }
    }


        public void countBoy (int startNo , int countNum , int nums ){
        if (first == null || startNo < 1 ||  startNo >nums){
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
         // 创造辅助指针， 帮助小孩完成出圈
            Boy helper =first;
        //需求创建一个辅助指针helper ， 事先指向环形链表的最后的节点
            while (true){
                if (helper.getNext() == first){ // 说明helper指向最后小孩节点
                    break;
                }
                helper = helper.getNext();
            }

           // 让小孩报数前， 先让first 和helper 移动 k-1次
            for (int i = 0; i < startNo - 1; i++) {
                first =first.getNext();
                helper = helper.getNext();
            }
            // 当小孩报数时， 让first 和helper指针同时移动， m-1次， 然后出圈
            while (true){
                if (first== helper){  // 圈中只剩下最后一个节点了
                    break;
                }
             // 让first 和 helper 指针同时移动countNum - 1
                for (int i = 0; i < countNum -1; i++) {
                    first =first.getNext();
                    helper = helper.getNext();
                }
              // 这时的first指向的节点， 就是小孩要出圈的那个
                System.out.printf("小孩%d出圈\n" , first.getNo());
             // 出圈操作
               first = first.getNext();
               helper.setNext(first);
            }
            System.out.printf("最后留在圈中的小孩的编号%d \n" , first.getNo());
    }
}



// 创建一个Boy ， 表示一个节点
class Boy {
    private int no;// 编号
    private Boy next; // 指向下一个节点， 默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}