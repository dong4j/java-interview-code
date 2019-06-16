package info.dong4j.interview.se;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: </p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-06-16 13:32
 */
public class Person {
    public int num = 10;
}

class Student extends Person{
    public int num2 = 20;
    public int num = 30;

    public void show(){
        System.out.println(num);
        System.out.println(num2);
    }
}

class Demo{
    public static void main(String[] args) {
        Student student = new Student();
        student.show();
    }
}
