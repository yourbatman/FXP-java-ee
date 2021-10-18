package cn.yourbatman.coding.jmx.diy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/18 21:15
 * @since 0.0.1
 */
@ToString
@Getter
@Setter
public class User implements UserMBean {

    private String name;
    private int age;

}
