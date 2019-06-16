package info.dong4j.interview.se;

// 成员内部类......相当于非静态方法
class Outer{
    private int a = 3;
    private Inner in;
    public Outer(){
        in = new Inner();
    }
    public int getInnerA(){
        return in.a;  // 引用内部类的变量, 需通过实例
    }
    public class Inner {
        public int a = 2;
        public void doSomething() {
            // 调用外部类的属性
            System.out.println(Inner.this.a);// 这块要注意......很重要！！！
            System.out.println(a);
        }
    }
}

public class Test3 {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();// 非静态内部类要new实例
        inner.doSomething();
    }
}

class Extender extends Outer.Inner{
    public Extender(Outer outer){
       //外部类实例名.super(内部类参数列表)
       outer.super();
    }
}