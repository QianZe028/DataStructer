//public class SingleLinkedListDemo {
//    public static void main(String[] args) {
//          //进行测试
//         //先创建节点
//         HeroNode hero1 = new HeroNode(1 , "宋江" , "及时雨");
//         HeroNode hero2 = new HeroNode(2 , "卢俊义" , "玉麒麟");
//         HeroNode hero3 = new HeroNode(3 , "吴用" , "智多星");
//         HeroNode hero4 = new HeroNode(4 , "林冲" , "豹子头");
//        //创建一个链表
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//
//        //加入 缺点，，没有考虑编号排名，不完美
//       /* singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
//*/
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero2);
//
//        //显示一下
//        singleLinkedList.list();
//
//        //测试一下修改
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~!");
//        singleLinkedList.update(newHeroNode);
//
//        System.out.println("修改后的链表为");
//        singleLinkedList.list();
//
//        singleLinkedList.delete(1);
//        System.out.println("删除后链表的情况");
//        singleLinkedList.list();
////        singleLinkedList.delete(4);
////        System.out.println("删除后链表的情况");
////        singleLinkedList.list();
////        singleLinkedList.delete(3);
////        System.out.println("删除后链表的情况");
////        singleLinkedList.list();
////        singleLinkedList.delete(2);
////        System.out.println("删除后链表的情况");
////        singleLinkedList.list();
//
//       //测试一下
//
//        System.out.println(getLength(singleLinkedList.getHead()));
//
//      // 测试一下是否找到
//        HeroNode res = findLastNode(singleLinkedList.getHead() , 1);
//        System.out.println(res);
//    }
//
//    // 作业1     统计有效节点的个数
//    public static int getLength(HeroNode head){
//        int length = 0;
//        if (head.next == null){
//            return 0;
//        }
//        HeroNode temp = head.next;
//       while (temp != null){
//           length ++ ;
//          temp = temp.next;
//       }
//      return  length;
//    }
//
//    //查找单链表中的倒数第K个节点
//    //思路
//    //1.编写一个方法，能接受head 节点， 和index倒数第--个节点
//    //2.index表示倒数第n个节点
//    //3.先把链表从头到尾遍历 ，得到length
//    //4.得到size后， 从链表的第一个节点开始遍历 (size - index)个
//    //5.如果找到了， 返回该节点， 否则返回null
//
//     public  static  HeroNode findLastNode (HeroNode head , int index){
//         //如果链表为空， 返回null
//         if (head.next == null){
//             return null;
//         }
//         //得到size
//     int size = getLength(head);
//     if (index <= 0 || index > size){
//         return  null;
//     }
//         HeroNode temp = head.next;
//         for (int i = 0 ; i < size - index; i++){
//              temp =temp.next;
//         }
//         return temp;
//    }
//      //将单链表反转
//    public  static  void  reversetList (HeroNode head){
//        //如果当前链表为空， 或者只有一个节点，无需反转
//        if (head.next == null || head.next.next == null){
//            return;
//        }
//       // 定义一个辅助变量 ， 辅助遍历
//        HeroNode cur = head.next;
//        HeroNode next = null;   //指向当前节点的cur 的下一个节点
//        HeroNode reverseHead = new HeroNode(0 , "" , "");
//      // 遍历原来的链表 , 每遍历一个节点， 取出， 放在新链表reverseHead最前端
//      while (cur != null){
//          next = cur.next;
//           cur.next= reverseHead.next;
//            reverseHead.next= cur;
//             cur= next;
//      }
//
//                          //*       next = 3
//               // 0 -> 1--> 2 -> ->3
//               // 0---3---2----2
//    }
//
//}
//
//class SingleLinkedList {
//    //头、初始化一个头结点，头结点不能动，不给具体数据
//    private  HeroNode head = new HeroNode(0 ,"","");
//
//    public HeroNode getHead() {
//        return head;
//    }
//
//    //
//    public void add (HeroNode heroNode){
//   //因为头结点不能动，我们需要一个辅助变量temp来遍历
//        HeroNode temp = head;
//        while (true){
//             if (temp.next == null){
//                 break;
//             }
//            //如果没有找到最后 ，后移
//        temp = temp.next;
//        }
//      //当temp 的next域为空时，退出while循环
//        //开始将新节点赋给temp
//        //这句话是真正完成添加的
//        temp.next = heroNode;
//    }
//
//    //第二种遍历方式
//    public  void addByOrder (HeroNode heroNode){
//        //头结点不能动，需要辅助变量
//        HeroNode temp = head;
//        boolean flag = false;
//        while (true){
//            if (temp.next == null){
//                break;
//            }
//            if (temp.next.no > heroNode.no ){
//                break;
//            } else if (temp.next.no == heroNode.no) {
//                flag = true;//说明编号存在
//                break;
//            }
//            temp = temp.next; //后移，相当于遍历当前链表
//        }
//        if(flag){
//            System.out.printf("准备插入的%d已经存在了，无法在加入" , heroNode.no);
//        }else {
//            //插入到链表中 , temp 后边
//            heroNode.next = temp.next;
//            temp.next = heroNode;
//        }
//    }
//
//    //修改节点的信息
//    //no不能修改，而且要根据他来判断哪个需要修改
//    public  void  update (HeroNode newHeroNode){
//        //判断是否为空
//        if (head.next == null){
//            System.out.println("链表为空~");
//             return;
//        }
//        //找到需要修改的节点，根据no编号
//        //定义一个辅助变量
//         HeroNode temp = head.next;
//        boolean flag = false;// 标志是否找到了节点
//        while (true){
//            if (temp == null){
//                break;//表示已经遍历完链表
//            }
//            if(temp.no == newHeroNode.no){
//                //找到了
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//        }
//        //根据flag 是否被修改过，来判断是否找到了该节点
//        if (flag){
//             temp.name= newHeroNode.name;
//             temp.nickname = newHeroNode.nickname;
//        }else {
//            System.out.printf("没有找到编号为%d的节点 , 不能修改" , newHeroNode.no);
//        }
//    }
//      // 删除节点
//
//      // head不能动,我们仍然需要一个temp 辅助节点来找到前一个节点
//      //我们比较的text.next的no ,不是temp 的no
//     public void  delete (int no ){
//         HeroNode temp= head;
//         boolean flag = false;  //判断是否找到
//         while (true){
//             if (temp.next == null){
//                 break;
//             }
//             if (temp.next.no == no){
//                 flag = true;
//                 break;
//             }
//         temp = temp.next;
//         }
//         if (flag ) {
//             temp.next= temp.next.next;
//         }else {
//             System.out.printf("要删除的编号为%d的节点不存在 " , no );
//         }
//    }
//
//    //遍历链表
//    public  void list (){
//        //链表是否为空
//        if (head.next == null){
//            System.out.println("链表为空， 无法遍历");
//            return;
//        }
//        //头结点不能动，仍然辅助遍历
//        HeroNode temp = head.next;
//        while (true){
//            //判断是否到最后
//            if (temp == null){
//                break;
//             }
//            System.out.println(temp);
//            temp = temp.next;
//        }
//    }
//
//
//}
//
//
//
//class HeroNode {
//    public  int no ;
//    public  String name;
//    public  String nickname;
//    public  HeroNode next; //指向下一个节点
//
//    //构造器
//// 完成初始化工作，但是，不能动next
//    public HeroNode(int no, String name, String nickname) {
//        this.no = no;
//        this.name = name;
//        this.nickname = nickname;
//    }
//
//    @Override
//    public String toString() {
//        return "HeroNode{" +
//                "no=" + no +
//                ", name='" + name + '\'' +
//                ", nickname='" + nickname + '\'' +
//                '}';
//    }
//}