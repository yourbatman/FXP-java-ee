package cn.yourbatman.coding.jmx.diy;

/**
 * MBean资源通过接口暴露，【一定必须】以MBean结尾才算一个MBean
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/18 21:14
 * @since 0.0.1
 */
public interface UserMBean {

    String getName();

    void setName(String name);

    void setAge(int age);
}
