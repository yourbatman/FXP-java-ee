package cn.yourbatman.coding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/6 21:20
 * @since 0.0.1
 */
public class JDBCDemo {

    // ==================JDBC 四大参数 ======================
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";

    public static void main(String[] args) throws Exception {
        Class.forName(DB_DRIVER);
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement("SELECT id,name,age FROM user", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {


            // ==============获取到连接后，即可开始操作数据库==================
            ResultSet rs = pstmt.executeQuery();

            //进行结果集滚动操作 打印结果集
            System.out.println("第二条数据：" + rs.getLong("id"));
            rs.absolute(1);
            System.out.println("第一条数据：" + rs.getLong("id"));
            rs.beforeFirst();
            System.out.println("最后一条数据：" + rs.getLong("id"));
            rs.afterLast();

            // 关闭结果集（应该在finally关闭）
            rs.close();
        }
    }

}
