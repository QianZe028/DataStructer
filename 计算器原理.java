import java.util.SplittableRandom;
import java.util.concurrent.LinkedTransferQueue;

public class 计算器原理 {
    public static void main(String[] args) {
        String expression = "70+2*6-4";
        // 创建两个栈  ，数栈， 符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0;  // 用于扫描的
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描得到的char保存到ch中
        String keepNum = "";
        // 开始while循环的扫描expression
        while (true) {
            // 依次得到expression中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判读ch是是， 。然做处理
            if (operStack.isOper(ch)) {
                // 如果是 运算符
                if (!operStack.isEmpty()) {
                    // 如果栈不是空的， 我就得进行比较，优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);

                        // 把运算结果加到数栈里
                        numStack.push(res);
                        // 然后把当前的操作符加入到符号栈中
                        operStack.push(ch);
                    } else {
                        // 如果要加进来的符号优先级比当前最顶上的符号大， 直接入栈
                        operStack.push(ch);
                    }
                } else {
                    // 如果是空的。 直接加入符号栈
                    operStack.push(ch);
                }
            } else {
                // 如果是数， 直接入数栈
                numStack.push(ch - 48);
            }

  /*           // 让负责扫描的index++ ， 并判断是否扫描到了experssion最后
            index++;
            if (index >= expression.length()){
                break;
              // index是从0 开始的， 类似数组
    */
            //这么写有问题 ， 当时多位数的时候出现错误 ，改进：
            //   在处理的时候， 需要向 index后面再多看一位， 如果是数 ， 仍然
            // 需要扫描 ， 如果是符号 才能入栈
            // 定义一个 变量字符串， 用于拼接
            // 处理多位数

            keepNum += ch;

            // 如果ch已经是expression的最后一位， 直接入栈
            if (index == expression.length() - 1) {
                numStack.push(Integer.parseInt(keepNum));
            } else {
                // 判断下一个字符是不是数字， 如果是， 就继续扫描 ，
                // 如果是运算符 ，则入栈
                if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                    numStack.push(Integer.parseInt(keepNum));
                    // 很重要！！！！！ 要清空keepNum
                    keepNum = "";
                }
            }


            // 当表达式扫描完毕， 就顺序的从数栈和符号栈中pop 出相应的数和符号。 并运行
            while (true) {
                // 如果符号栈为空 ， 则计算到最后的结果， 数栈中只有一个数字即结果
                if (operStack.isEmpty()) {
                    break;
                }
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = numStack.cal(num1, num2, oper);
                numStack.push(res);// 入栈
            }
            int res2 = numStack.pop();
            System.out.printf("表达式%s = %d", expression, res2);
        }
    }
}

    class ArrayStack2 {
        private int maxSize;
        private int[] stack;
        private int top = -1;

        public int peek() {
            return stack[top];
        }

        public ArrayStack2(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[this.maxSize];
        }// 初始化 ，创建个栈数组

        //  栈满
        public boolean isFull() {
            return top == maxSize - 1;
        }

        //栈空
        public boolean isEmpty() {
            return top == -1;
        }

        // 入栈 push
        public void push(int value) {
            if (isFull()) {
                System.out.println("栈满");
                return;
            }
            top++;
            stack[top] = value;
        }

        // 出栈
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈空， 没有数据~");
            }
            int value = stack[top];
            top--;
            return value;
        }

        // 显示栈的情况 [遍历栈] ,
        public void list() {
            if (isEmpty()) {
                System.out.println("栈空， 没有数据~");
            }
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack [%d] =%d \n ", i, stack[i]);
            }
        }

        // 返回运算符的优先级， 优先级由程序员来确定，用数字表示
// 数字越大， 优先级越高
        public int priority(int oper) {
            if (oper == '*' || oper == '/') {
                return 1;
            } else if (oper == '+' || oper == '-') {
                return 0;
            } else {
                return -1;
            }
        }

        // 判断是不是一个运算符
        public boolean isOper(char val) {
            return val == '+' || val == '-' || val == '*' || val == '/';

        }

        // 计算方法
        public int cal(int num1, int num2, int oper) {
            int res = 0; //用于计算结果
            switch (oper) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
            }
            return res;
        }

    }


