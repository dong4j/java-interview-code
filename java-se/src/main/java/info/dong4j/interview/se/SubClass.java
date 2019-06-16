package info.dong4j.interview.se;

class ParentClass {
    public final void testFinal() {
        System.out.println("父类 -- 这是一个 final 方法");
    }

    public final void testFinal(String a){
        System.out.println("父类 -- 这是一个 final 重载方法");
    }
}

public class SubClass extends ParentClass {
    /**
     * 子类无法重写（override）父类的 final 方法, 否则编译时会报错
     */
    // public void TestFinal() {
    // System.out.println("子类 -- 重写 final 方法");
    // }

    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.testFinal();
        sc.testFinal("a");
    }
}