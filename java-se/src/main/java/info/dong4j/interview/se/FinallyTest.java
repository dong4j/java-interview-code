package info.dong4j.interview.se;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(new FinallyTest().test());
    }

    private int test() {
        try {
            return func1();
        } finally {
            return func2();
        }
    }

    private int func1() {
        System.out.println("func1");
        return 1;
    }

    private int func2() {
        System.out.println("func2");
        return 2;
    }
}