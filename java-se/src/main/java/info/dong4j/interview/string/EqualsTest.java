package info.dong4j.interview.string;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: == 与 equals </p>
 *
 * @author dong4j
 * @date 2019-03-07 11:54
 * @email sjdong3@iflytek.com
 */
@Slf4j
public class EqualsTest {
    public static void main(String[] args) {
        String a = "ab";
        String b = "ab";

        String aa = "ab";
        String bb = "ab";

        log.info("a == b: {}", a == b);
        log.info("aa == bb: {}", aa == bb);
        log.info("a.equals(b): {}", a.equals(b));
        log.info("42 == 42.0: {}", 1 == 1.0);

        int i = 42;
        double y = 42.0;
        log.info("42 == 42.0: {}", i == y);
        log.info("3 * 0.1 == 0.3: {}", 3 * 0.1 == 0.3);
    }
}