package info.dong4j.interview.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: </p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-03-02 22:00
 */
public class JVMProfilerTest {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            ;
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
        }
    }
}
