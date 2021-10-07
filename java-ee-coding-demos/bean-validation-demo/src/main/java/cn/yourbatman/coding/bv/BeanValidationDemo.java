package cn.yourbatman.coding.bv;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/6 10:15
 * @since 0.0.1
 */
public class BeanValidationDemo {

    /**
     * 校验Bean
     */
    @Test
    public void validBean() {
        // 使用默认配置获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        // 准备（待校验的）Bean
        Person person = new Person();
        person.setId(-1);
        person.setName("YourBatman");
        person.setAge(18);

        // 使用校验器对其执行校验
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        // 打印校验结果
        if (violations.isEmpty()) {
            System.out.println("校验通过！");
        } else {
            System.out.println("校验不通过！错误详情如下：");
            violations.forEach(v -> System.out.println("\t" + v.getPropertyPath() + v.getMessage() + "，但你的值是：" + v.getInvalidValue()));
        }
    }

    /**
     * 校验方法
     */
    @Test
    public void validMethod() throws NoSuchMethodException {
        toInt(null);
    }


    public @Positive int toInt(@NotNull String numStr) throws NoSuchMethodException {
        // 使用默认配置获得验证器（用于方法、构造器的校验器）
        ExecutableValidator executableValidator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();
        // 执行参数校验逻辑start...
        Method currMethod = BeanValidationDemo.class.getMethod("toInt", String.class);
        Set<ConstraintViolation<BeanValidationDemo>> violations = executableValidator.validateParameters(this, currMethod, new Object[]{numStr});
        // 打印校验结果
        if (violations.isEmpty()) {
            System.out.println("校验通过！");
        } else {
            System.out.println("校验不通过！错误详情如下：");
            violations.forEach(v -> System.out.println("\t" + v.getPropertyPath() + v.getMessage() + "，但你的值是：" + v.getInvalidValue()));
            throw new IllegalArgumentException("校验不通过！"); //抛出异常，终止此方法
        }
        // 执行参数校验逻辑end...

        int result = Integer.parseInt(numStr);
        // 执行返回值校验逻辑start
        // executableValidator.validateReturnValue();
        // 执行返回值校验逻辑end
        return result;
    }

}
