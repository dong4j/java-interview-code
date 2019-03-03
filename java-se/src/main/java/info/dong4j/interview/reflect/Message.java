package info.dong4j.interview.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: </p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-03-04 07:04
 */
@Slf4j
public class Message {
    public void showMessage(String message){
        log.info("message: {}", message);
    }
}
