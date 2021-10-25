package cn.yourbatman.coding.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * 相当于资源管理器，启动此管理器就启用了资源
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/24 17:22
 * @since 0.0.1
 */
public class MyResourceConfig extends ResourceConfig {

    // 在构造阶段，暴露资源
    public MyResourceConfig() {
        register(HelloResource.class);
    }
}
