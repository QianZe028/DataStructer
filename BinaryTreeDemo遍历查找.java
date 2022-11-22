public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();

        // 创建需要的节点
        HeroNode01 root = new HeroNode01(1, "宋江");
        HeroNode01 node2 = new HeroNode01(2, "吴用");
        HeroNode01 node3 = new HeroNode01(3, "卢俊义");
        HeroNode01 node4 = new HeroNode01(4, "林冲");
        HeroNode01 node5 = new HeroNode01(5,"关胜" );

        // 我们先手动创建二叉树， 加深学习
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

       // 测试前序遍历
        System.out.println("前序遍历"); // 1234
        binaryTree.preOrder01();
        System.out.println("================");
        binaryTree.infixOrder01();
        System.out.println("================");
        binaryTree.postOrder01();
    }
}

// 定义BinaryTree 二叉树
class  BinaryTree {
    private  HeroNode01 root;

    public  void  setRoot (HeroNode01 root){
        this.root =root;
    }

   // 前序遍历
    // 真正的业务逻辑不再这里
    public  void  preOrder01(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空， 无法遍历 ");
        }
    }


     // 中序遍历
    public void infixOrder01(){
        if (this.root != null){
            this.root.infixOerder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public  void postOrder01(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空 ， 无法遍历");
        }
    }

    // 前序遍历
    public  HeroNode01 preOrderSearch(int no){
        if (root != null){
            return  root.preOrderSearch(no);
        }else {
            return  null;
        }
    }

    // 中序遍历
    public HeroNode01 infixOrderSearch(int no ){
        if (root != null){
            return  root.infixOrderSearch(no);
        }else {
            return  null;
        }
    }


    // 后序遍历
    public HeroNode01 postOrderSearch (int no){
        if (root != null){
            return  this.root.postOrderSearch(no);
        }else {
            return  null;
        }
    }
}


class HeroNode01{
    private  int no;
    private  String name;
    private  HeroNode01 left;
    private  HeroNode01 right;

    public HeroNode01(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode01 getLeft() {
        return left;
    }

    public void setLeft(HeroNode01 left) {
        this.left = left;
    }

    public HeroNode01 getRight() {
        return right;
    }

    public void setRight(HeroNode01 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode01{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

         // 编写前序遍历的方法
    public  void preOrder (){
        System.out.println(this); // 先输出父节点
           // 递归向左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
           // 递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

   // 中序遍历
    public void infixOerder(){
         // 递归向左子树中序遍历
        if (this.left != null){
            this.left.infixOerder();
        }
          // 输出父节点
        System.out.println(this);
       // 递归向右子树中序遍历
        if (this.right != null){
            this.right.infixOerder();
        }
    }

    // 后序遍历
    public  void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
       if (this.right != null){
           this.right.postOrder();
       }
           // 输出父节点
         System.out.println(this);
    }

       // 前序遍历查找
    /*
    *   no 查找no
    *   如果找到就返回该Node ， 找不到就返回null
    * */

    public HeroNode01 preOrderSearch(int no){
        System.out.println("进入前序遍历");
        // 比较当前的节点是不是.
        if (this.no == no){
            return  this;
        }
       // 1. 判断当前节点的左子节点是否为空， 如果不为空， 则递归前序查找
        HeroNode01 resNode = null;

        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }

        if (resNode != null){ // res不为空则说明我们已经找到了
            return  resNode;
        }

       // 1.左递归前序查找， 找到节点，则返回，否则将继续判断
        //2. 当前的节点的右子节点是否为空， 如果不为空， 则向右递归前序查找

        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
       return  resNode;

    }


    // 中序遍历查找

    public HeroNode01 infixOrderSearch(int no){
        // 判断当前节点的左子节点是否为空， 如果不为空， 则递归中序查找
        HeroNode01 resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }

      if (resNode != null){
          return  resNode;
      }

       // 如果找到， 则返回，没有找到 ，就和当前节点比较，如果是，则返回当前的节点

       if (this.no == no){
           return this;
       }

       // 否则继续进行右递归的中序查找
        if (this.right != null){
            resNode  = this.right.infixOrderSearch(no);
        }
     return  resNode;
    }


    //后序遍历查找
    public HeroNode01 postOrderSearch(int no){

        // 判读当前节点的左子节点是否为空， 如果不为空，则递归后序查找
           HeroNode01 resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }

       if (resNode != null){ // 说明左子树找到
           return  resNode;
       }

       // 如果左子树没有找到， 则向右子树递归进行后续遍历查找

        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }

        if (resNode != null){
            return  resNode;
        }
        System.out.println("进入后序查找");

        // 如果左右子树都没有找到， 则比较当前节点是不是

         if (this.no == no){
             return  this;
         }

       return  resNode;
    }

}

