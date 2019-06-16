package info.dong4j.interview.se;

import org.jetbrains.annotations.Contract;

import java.io.*;

import lombok.Data;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 克隆</p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-06-16 15:44
 */
public class Clone {
    public static void main(String[] args) throws Exception {
        // 创建父亲(LiLiu)，儿子(LiWu)，孙子（LiLiu）并关联
        Son father = new Son();
        father.setName("LiSi");
        Son son = new Son();
        son.setName("LiWu");
        Son grandSon = new Son();
        grandSon.setName("LiLiu");
        father.setSon(son);
        son.setSon(grandSon);
        // 调用clone方法 (浅克隆)
        Son fatherCopy = (Son) father.clone();
        boolean flag1 = fatherCopy == father;
        boolean flag2 = fatherCopy.getSon() == son;
        boolean flag3 = fatherCopy.getSon().getSon() == grandSon;
        // 比较克隆后的地址
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        // 比较Name
        flag1 = fatherCopy.getName() == father.getName();
        flag2 = fatherCopy.getSon().getName() == son.getName();
        flag3 = fatherCopy.getSon().getSon().getName() == grandSon.getName();
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);

        // 深克隆
        // 将对象写到流里
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(father);
        //从流里读出来
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream objInput = new ObjectInputStream(byteIn);
        fatherCopy = (Son) objInput.readObject();
        flag1 = fatherCopy == father;
        flag2 = fatherCopy.getSon() == son;
        flag3 = fatherCopy.getSon().getSon() == grandSon;
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);

        // 比较Name
        flag1 = fatherCopy.getName() == father.getName();
        flag2 = fatherCopy.getSon().getName() == son.getName();
        flag3 = fatherCopy.getSon().getSon().getName() == grandSon.getName();
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
    }
}

@Data
class Son implements Serializable, Cloneable {
    private String name;
    private Son son;

    @Contract(pure = true)
    Son() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}