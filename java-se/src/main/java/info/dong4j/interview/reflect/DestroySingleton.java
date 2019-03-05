package info.dong4j.interview.reflect;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 通过反射和 unsafe 破坏单例 </p>
 *
 * @author dong4j
 * @email sjdong3 @iflytek.com
 * @since 2019 -03-04 08:49
 */
@Slf4j
public class DestroySingleton {

    public static void main(String[] args) throws InvocationTargetException,
                                                  NoSuchMethodException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  NoSuchFieldException {
        Singleton singleton1 = Singleton.getSingleton();

        Singleton singleton2 = destroyByReflect(Singleton.class);

        if (singleton1 == singleton2) {
            log.info("destroyByReflect: 相等 singleton = {}", singleton1);
        } else {
            log.info("destroyByReflect: 不相等. singleton1 = {}, singleton2 = {}", singleton1, singleton2);
        }

        destroyByUnsafeApi();
    }

    private static <T> T destroyByReflect(Class<T> tClass) throws NoSuchMethodException,
                                                                  IllegalAccessException,
                                                                  InvocationTargetException,
                                                                  InstantiationException {
        // 获取当前Class所表示类中指定的一个的构造器,和访问权限无关
        Constructor<T> constructor = tClass.getDeclaredConstructor();
        // 设置私有方法的可访问
        constructor.setAccessible(true);
        //实例化对象
        return constructor.newInstance();
    }


    private static void destroyByUnsafeApi() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeField.setAccessible(true);
        Unsafe unsafeInstance = (Unsafe) theUnsafeField.get(null);

        Singleton instanceA = (Singleton) unsafeInstance.allocateInstance(Singleton.class);
        Singleton instanceB = (Singleton) unsafeInstance.allocateInstance(Singleton.class);

        log.info("destroyByUnsafeApi: {}", instanceA == instanceB ? "相等" : "不相等");
    }
}


/**
 * DCL方式获取单例
 */
class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }
}
