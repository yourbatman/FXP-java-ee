package cn.yourbatman.coding.jmx.diy;

import org.junit.jupiter.api.Test;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/18 21:17
 * @since 0.0.1
 */
public class DiyDemo {

    @Test
    public void test1() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.yourbatman:type=UserXXX"); // 名字可任意取，但最好见名知意
        mBeanServer.registerMBean(new User(), objectName);

        // 线程保活，方便获取MBean
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void test2() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        LocateRegistry.createRegistry(9090); // 这一步不能少，不需要返回值
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:9090/userXXX");
        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mBeanServer);
        cntorServer.start();

        ObjectName objectName = new ObjectName("com.yourbatman:type=UserXXX");
        mBeanServer.registerMBean(new User(), objectName);

        // 线程保活，方便获取MBean
        Thread.sleep(Long.MAX_VALUE);
    }

}
