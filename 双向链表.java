public class 双向链表 {
  // 单向链表缺点 ： 查找只能是一个方向 ， 双向链表可以双向
    // 单向不能自我删除 ， 而双向可以
     // 遍历 和单链表一样 ， 可以向前也可以向后
    // 添加 默认添加到 最后
      // 先找到双向的最后
      //temp.next = newHeroNode
    // newHeroNode.pre = temp;
    //修改
    //删除     直接找到
    //temp.pre.next = temp.next;
    // temp.next.pro = temp.pre;
  public static void main(String[] args) {
      HeroNode2 hero1 = new HeroNode2(1 , "宋江" , "及时雨");
      HeroNode2 hero2 = new HeroNode2(2 , "卢俊义" , "玉麒麟");
      HeroNode2 hero3 = new HeroNode2(3 , "吴用" , "智多星");
      HeroNode2 hero4 = new HeroNode2(4 , "林冲" , "豹子头");
      DoubleLinkedList d1=  new DoubleLinkedList();
      d1.add2(hero1);
  }


}

//创建一个双向链表的类
class DoubleLinkedList{

    //先初始化一个头结点， 不动 ， 不存放具体数据
    private  HeroNode2 head = new HeroNode2(0 , "" , "");

    //返回头结点
    public HeroNode2 getHead(){
        return head;
    }

   //遍历双向链表
   // 显示链表
    public void List (){
        //判断链表是否为空
            if (head.next == null){
                System.out.println("链表为空");
                return;
            }

            //如果不为空， 来一个temp 辅助遍历
      HeroNode2 temp = head.next;
      while (true){
          // 判断是否到最后
          if (temp == null){
              break;
          }
          System.out.println(temp);
          //后移
          temp = temp.next;
      }
    }

    //添加
    public  void add2(HeroNode2 heroNode){
        // 空不空没关系
        HeroNode2 temp = head;
        //遍历链表 ， 就是像让temp 指向链表最后
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
       // 当退出while后 ， temp就确实指在了链表的最后
      temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改一个节点
    public void update (HeroNode2 newHeroNode){
        if (head.next == null){
            System.out.println("链表为空");
        return;
        }

        // 找到要修改的编号

       HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
          if (temp.no == newHeroNode.no){
              flag = true;
            break;
          }
        }
          if (flag){
            temp.name = newHeroNode.name;
            temp.nickname=  newHeroNode.nickname;
          }else {
              System.out.printf("没找到编号%d的英雄" , newHeroNode.no);
          }
    }

      // 删除
    public void del (int no){

        if (head.next == null){
            System.out.println("链表为空, 无法删除");
            return;
            // break 只能在循环里使用
        }
         HeroNode2 temp= head.next;
        boolean flag = false;
        while (true){
            if (temp ==null){
                break;
            }
            if (temp.no == no){
                flag =true;
                break;
            }
          temp = temp.next;
        }
      if (flag){
          // 开始删除
          //  1  2  3  4  5
           //temp.next= temp.next.next;
           temp.pre.next = temp.next;

         if (temp.next != null){
             temp.next.pre = temp.pre;
         }
      }else {
          System.out.printf("要删除的%d节点不存在" ,no);
      }

    }
}
// 定义一个HeroNode对象
class HeroNode2 {
      public  int no;
      public  String name;
      public  String nickname;
      public  HeroNode2 next;
      public  HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}