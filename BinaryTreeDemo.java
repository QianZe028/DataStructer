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
}

