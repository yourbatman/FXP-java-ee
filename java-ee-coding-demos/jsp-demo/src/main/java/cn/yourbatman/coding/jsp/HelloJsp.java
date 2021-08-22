package cn.yourbatman.coding.jsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/9/12 06:26
 * @since 0.0.1
 */
@WebServlet(urlPatterns = {"/hellojsp"})
public class HelloJsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hello.jsp");
        // 放在WBE-INF下面的.jsp页面必须通过Servlet转发才能访问到，更加安全
        // RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/hello.jsp");
        requestDispatcher.forward(request, response);
    }
}