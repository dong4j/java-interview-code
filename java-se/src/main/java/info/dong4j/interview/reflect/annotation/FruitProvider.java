package info.dong4j.interview.reflect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 水果供应者注解 </p>
 *
 * @author dong4j
 * @date 2019-03-04 06:36
 * @email sjdong3@iflytek.com
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     */
    int id() default -1;
    
    /**
     * 供应商名称
     */
    String name() default "";
    
    /**
     * 供应商地址
     */
    String address() default "";
}