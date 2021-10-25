package cn.yourbatman.coding.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/24 17:24
 * @since 0.0.1
 */
@Path("/hello")
public class HelloResource {

    @Path("/demo")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String demo() {
        return "hello jax-rs...";
    }
}
