package cn.yourbatman.coding.jsonb;

import lombok.Data;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/9/12 19:57
 * @since 0.0.1
 */
public class JsonbDemo {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("YourBatman");
        p.setAge(18);

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(p);
        System.out.println("序列化结果：" + json);

        // 反序列化
        System.out.println("返序列化结果：" + jsonb.fromJson(json, Person.class));
    }

}

