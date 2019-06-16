package info.dong4j.interview.reflect;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 创建实例测试</p>
 *
 * @author dong4j
 * @email sjdong3 @iflytek.com
 * @since 2019 -03-03 19:55
 */
@Slf4j
public class CreateInstance {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static void main(String[] args) throws InstantiationException,
                                                  IllegalAccessException,
                                                  NoSuchMethodException,
                                                  InvocationTargetException {
        Object object = classNewInstance(String.class);
        log.info("{}", object.getClass().isInstance(""));
        object = constructorNewInstance();
        log.info("{}", object);
    }


    /**
     * 使用 Class 对象的 newInstance() 方法来创建 Class 对象对应类的实例
     *
     * @param clz the clz
     * @return the object
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     */
    private static Object classNewInstance(@NotNull Class clz) throws IllegalAccessException,
                                                                      InstantiationException {
        return clz.newInstance();
    }

    /**
     * 先通过 Class 对象获取指定的 Constructor 对象，再调用 Constructor 对象的 newInstance() 方法来创建实例
     * 这种方法可以用指定的构造器构造类的实例
     *
     * @return the object
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws InstantiationException    the instantiation exception
     */
    @NotNull
    private static Object constructorNewInstance() throws NoSuchMethodException,
                                                          IllegalAccessException,
                                                          InvocationTargetException,
                                                          InstantiationException {
        // 获取String所对应的Class对象
        Class<?> c = String.class;
        // 获取String类带一个String参数的构造器
        Constructor constructor = c.getConstructor(String.class);
        // 根据构造器创建实例
        return constructor.newInstance("23333");
    }
}
