package cn.yourbatman.coding.bv;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/6 10:16
 * @since 0.0.1
 */
@Data
public class Person {

    @Positive
    private long id;
    @NotBlank
    private String name;
    @NotNull
    @PositiveOrZero
    private Integer age;

}
