package info.dong4j.interview.reflect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 水果颜色注解</p>
 *
 * @author dong4j
 * @date 2019-03-04 06:37
 * @email sjdong3@iflytek.com
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    enum Color {BLUE, RED, GREEN}

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}