package info.dong4j.interview.se;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: toString 导致的递归</p>
 *
 * @author dong4j
 * @date 2019-06-16 13:45
 * @email sjdong3@iflytek.com
 */
public class InfiniteRecursion {

    // @Override
    // public String toString() {
    //     // this关键字会调用 this.toString() 方法，产生递归
    //     // 修改为super.toString()
    //     return this + "InfiniteRecursion";
    // }

    public static void main(String[] args) {
        InfiniteRecursion ir = new InfiniteRecursion();
        System.out.println(ir.toString());
    }

}