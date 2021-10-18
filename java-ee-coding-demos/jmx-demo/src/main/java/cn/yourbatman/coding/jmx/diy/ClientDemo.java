package cn.yourbatman.coding.jmx.diy;

import org.junit.jupiter.api.Test;

import javax.management.JMX;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/18 21:40
 * @since 0.0.1
 */
public class ClientDemo {

    @Test
    public void test1() throws Exception {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:9090/userXXX");
        JMXConnector conn = JMXConnectorFactory.connect(url, null);

        UserMBean userMBean = JMX.newMBeanProxy(conn.getMBeanServerConnection(), new ObjectName("com.yourbatman:type=UserXXX"), UserMBean.class);
        System.out.println("通过RMI协议拿到：" + userMBean);
        System.out.println("user的名字：" + userMBean.getName());

        conn.close();
    }

}
