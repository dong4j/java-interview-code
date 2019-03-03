package info.dong4j.interview.reflect.annotation;

import lombok.Data;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 使用注解 </p>
 *
 * @author dong4j
 * @date 2019-03-04 06:37
 * @email sjdong3@iflytek.com
 */
@Data
class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvider;
}