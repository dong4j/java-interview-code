package info.dong4j.interview.reflect;

import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: </p>
 *
 * @author dong4j
 * @date 2019-03-04 07:01
 * @email sjdong3@iflytek.com
 */
@Slf4j
public class ReadProperties {
    // 获取配置文件属性
    private static String getValue() throws Exception {
        // 获取配置文件的对象
        Properties properties = new Properties();
        // 获取输入流

        ClassLoader classLoader = ReadProperties.class.getClassLoader();
        // getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
        URL url = classLoader.getResource("app.properties");
        assert url != null;
        log.debug(url.getFile());
        File file = new File(url.getFile());
        FileReader reader = new FileReader(file);
        // 将流加载到配置文件对象中
        properties.load(reader);
        reader.close();
        return properties.getProperty("message");
    }

    public static void main(String[] args) throws Exception {
        Class cla = Class.forName(getValue());
        Method method = cla.getDeclaredMethod("showMessage", String.class);
        Object object = cla.newInstance();
        // 调用配置文件中类的方法
        method.invoke(object, "hahaha");
    }
}