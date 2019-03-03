package info.dong4j.interview.reflect;

import java.lang.reflect.Array;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 反射创建数组 </p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-03-03 19:25
 */
@Slf4j
public class ArrayTest {
    public static void main(String[] args) throws ClassNotFoundException {
        testArray();
    }

    private static void testArray() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls, 25);
        //往数组里添加内容
        Array.set(array,0,"hello");
        Array.set(array,1,"Java");
        Array.set(array,2,"fuck");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        // 获取某一项的内容
        log.info("{}", Array.get(array,3));
    }
}


