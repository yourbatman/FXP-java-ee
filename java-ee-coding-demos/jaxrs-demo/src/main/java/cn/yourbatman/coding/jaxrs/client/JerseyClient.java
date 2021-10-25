package cn.yourbatman.coding.jaxrs.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey Client，发送Http请求
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/24 17:41
 * @since 0.0.1
 */
public class JerseyClient {

    public static void main(String[] args) {

        // ==== 创建Client的实例 ===
        Client client = ClientBuilder.newClient();
        WebTarget baseTarget = client.target("http://localhost:9090/yourbatman");

        // 具体请求
        WebTarget helloTarget = baseTarget.path("/hello/demo").queryParam("age", "18");
        // 发送get请求（可指定可接收的accept头）
        Response response = helloTarget.request("*").get();
        // Response response = helloTarget.request("text/plain", "text/html", "text/plain").get();

        // 打印结果
        int status = response.getStatus();
        String result = response.readEntity(String.class);
        System.out.println("响应状态码为：" + status + "，响应值为：" + result);
    }
}