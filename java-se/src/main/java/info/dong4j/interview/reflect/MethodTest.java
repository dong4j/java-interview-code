package info.dong4j.interview.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: </p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-03-03 19:46
 */
@Slf4j
public class MethodTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        test();
    }

    private static void test() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = MethodClass.class;
        // 创建 methodClass 实例
        Object object = c.newInstance();
        // 获取所有公用（public）方法，包括其继承类的公用方法。
        Method[] methods = c.getMethods();
        log.warn("getMethods 获取的方法：");
        for (Method m : methods) {
            log.info("{}", m);
        }
        // 获得类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Method[] declaredMethods = c.getDeclaredMethods();
        log.warn("getDeclaredMethods获取的方法：");
        for (Method m : declaredMethods) {
            log.info("{}", m);
        }

        // 获取 methodClass 类的 add 方法
        Method method = c.getMethod("add", int.class, int.class);
        // 调用method对应的方法 => add(1,4)
        Object result = method.invoke(object, 1, 4);
        log.info("result = {}", result);

    }
}

class MethodClass {
    public final int fuck = 3;

    public int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a + b;
    }
}
