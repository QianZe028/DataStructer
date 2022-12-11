import java.sql.SQLOutput;
import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {

        //创建 哈希表
        HashTab hashTable = new HashTab(7);

        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add  : 添加雇员");
            System.out.println("list : 显示雇员");
            System.out.println("find : 查找雇员");
            System.out.println("exit : 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    // 创建雇员
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.findById(id);
                    break;
                case " exit":
                    scanner.close();
            }
        }

    }

}

//创建哈希表,管理多条链表
class HashTab {
    private EmplinkedList[] emplinkedListArray;
    private int size;  // 表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        // 初始化emplinkedlistArray
        emplinkedListArray = new EmplinkedList[size];
        // 留坑  ，容易犯错！！！
        // 记着初始化每个链表
        for (int i = 0; i < size; i++) {
            emplinkedListArray[i] = new EmplinkedList();

        }
    }

    // 添加雇员
    public void add(Emp emp) {
        //根据员工的id ， 得到 该员工 应当添加到哪条链表
        int empLinedListNo = hashFun(emp.id);

        // 将emp添加到对应的链表中
        emplinkedListArray[empLinedListNo].add(emp);
    }

    // 遍历所有的链表 ， 遍历 hashTab
    public void list() {
        for (int i = 0; i < size; i++) {
            emplinkedListArray[i].show(i);
        }
    }

    // 根据输入的id ， 查找雇员
    public void findById(int id) {

        // 使用散列函数判断 要去哪条链表查找
        int NO = hashFun(id);
        Emp emp = emplinkedListArray[NO].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到了id为%d的员工", (NO + 1), id);
        } else {
            System.out.println("没有找到该雇员");
        }
    }

    // 编写散列函数 ， 使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }

}


// 表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 创建一个链表
class EmplinkedList {

    // 头指针 ，  指向第一个Emp， 因为链表的头结点是第一个Emp
    private Emp head;

    // 添加雇员到链表
    public void add(Emp emp) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        // 如果不是添加第一个
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        // 退出时 , 将节点挂上
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息

    public void show(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "链表的信息为");
        Emp curEmp = head;

        while (true) {
            // 这个顺序不能换！
            System.out.printf("==>  员工编号%d 员工姓名%s", curEmp.id, curEmp.name);

            if (curEmp.next == null) {
                break;
            }

            curEmp = curEmp.next;
        }
        System.out.println();
    }

    // 根据id 查找雇员
    //如果查找到 ， 就返回emp ， 如果没有找到， 就返回null
    public Emp findEmpById(int id) {
        // 判读链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                System.out.println("找到了");
                break;
            }

            if (curEmp.next == null) {
                curEmp = null;
                break;
            }

            curEmp = curEmp.next;
        }
        return curEmp;
    }

}
