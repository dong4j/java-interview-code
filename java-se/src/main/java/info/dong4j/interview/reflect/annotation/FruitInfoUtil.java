package info.dong4j.interview.reflect.annotation;

import java.lang.reflect.Field;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 注解处理器</p>
 *
 * @author dong4j
 * @date 2019-03-04 06:37
 * @email sjdong3@iflytek.com
 */
@Slf4j
class FruitInfoUtil {
    static void getFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                log.info("水果名称: {}", fruitName.value());
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                log.info("水果颜色: {}", fruitColor.fruitColor().toString());
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                log.info("供应商编号: {}, 供应商名称: {}, 供应商地址:{}", fruitProvider.id(), fruitProvider.name(), fruitProvider.address());
            }
        }
    }
}