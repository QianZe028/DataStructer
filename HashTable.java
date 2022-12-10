public class HashTable {
    public static void main(String[] args) {

    }

}

//创建哈希表,管理多条链表
class HashTab{
  private   EmplinkedList[] emplinkedListArray;
  private  int size;  // 表示有多少条链表
    public HashTab(int size) {
        // 初始化emplinkelistArray
         emplinkedListArray = new EmplinkedList[size];

    }

    // 添加雇员
    public void add (Emp emp){
        //根据员工的id ， 得到 该员工 应当添加到哪条链表
        int empLinedListNo = hashFun(emp.id);

        // 将emp添加到对应的链表中
        emplinkedListArray[empLinedListNo].add(emp);
    }

    // 遍历所有的链表 ， 遍历 hashTab
     public void list(){
         for (int i = 0; i < size; i++) {
             emplinkedListArray[i].show();
         }
     }

    // 编写散列函数 ， 使用一个简单的取模法
    public int hashFun(int id){
        return  id %size;
    }

}


// 表示一个雇员
class Emp {
   public  int id;
   public  String name;
   public  Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 创建一个链表
class EmplinkedList{

    // 头指针 ，  指向第一个Emp， 因为链表的头结点是第一个Emp
    private  Emp head;

    // 添加雇员到链表
    public void add(Emp emp){
       // 如果是添加第一个雇员
       if(head == null){
           head = emp;
           return;
       }
      // 如果不是添加第一个
        Emp curEmp = head;
       while (true){
           if (curEmp.next == null){
               break;
           }
           curEmp = curEmp.next;
       }
       // 退出时 , 将节点挂上
        curEmp.next = emp;
    }

       // 遍历链表的雇员信息

     public void show(){
        if (head == null){
            System.out.println("当前链表为空");
            return;;
        }
         System.out.println("链表的信息为");
        Emp curEmp = head;

     while (true){
         if (curEmp.next == null){
             break;
         }
         System.out.printf("员工编号%d 员工姓名%s" , curEmp.id, curEmp.name);
         curEmp = curEmp.next;
     }
         System.out.println();
    }

}