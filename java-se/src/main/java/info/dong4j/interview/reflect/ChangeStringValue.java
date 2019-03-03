package info.dong4j.interview.reflect;

import java.lang.reflect.Field;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 利用反射修改 String 的 value (JDK 6)</p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-03-03 20:39
 */
@Slf4j
public class ChangeStringValue {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        changeValue();
    }

    private static void changeValue() throws IllegalAccessException, NoSuchFieldException {
        String s = "abcd";
        log.info("修改前 s = {}", s);
        // 获取 String 类中的 value 字段
        Field valueField = String.class.getDeclaredField("value");
        // 改变 value 属性的访问权限
        valueField.setAccessible(true);
        // 获取 s 对象上的 value 属性的值
        char[] value = (char[]) valueField.get(s);
        // 改变 value 所引用的数组中的第 4 个字符
        value[3] = 'e';
        log.info("修改后 s = " + s);
        // 改变整个字符串
        valueField.set(s, new char[] {'1', '2', '3'});
        // 由于 JDK6 之后取消了 count 字段, 由 value.length 直接返回长度, 下面的代码将执行失败
        // 特别注意这里，因为改变了 value 的值，字符串长度已经改变了，需要同时改变 count 的值，不然使用 s 时会报数组越界 (JDK6)
        Field countField = String.class.getDeclaredField("count");
        countField.setAccessible(true);
        countField.set(s, 3);
        log.info("s = " + s);
    }
}
