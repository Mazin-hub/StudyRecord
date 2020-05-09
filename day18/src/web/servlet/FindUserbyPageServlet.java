package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *  分页查询
 */
@WebServlet("/findUserbyPageServlet")
public class FindUserbyPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 1.获取参数
            // 当前页码
        String currentPage = request.getParameter("currentPage");
            // 每页条数
        String rows = request.getParameter("rows");
        // 获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();
        // 默认处理，从index.jsp进来，没有参数或空参会报500的
        if(currentPage == null || "".equals(currentPage) /* || "0".equals(currentPage) */){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);
        // 2. 将PageBean存入request
        request.setAttribute("pb",pb);
            // 将查询条件也存入，做回显
        request.setAttribute("condition",condition);
        // 3. 转发
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
