package cn.yourbatman.coding.jpa;

import cn.yourbatman.coding.jpa.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/6 16:06
 * @since 0.0.1
 */
public class JPADemo {

    @Test
    public void fun1() {
        // 准备Hibernate的Session
        Configuration configure = new Configuration().configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 业务逻辑start
        User user = new User();
        user.setName("YourBatman");
        user.setAge(10);
        session.save(user);
        System.out.println("保存成功，id为：" + user.getId());
        // 业务逻辑end

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
