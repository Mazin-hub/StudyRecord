package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的数据格式为 json , 与 $.get()中第四个参数type,二选一
        response.setContentType("application/json;charset=utf-8");
        //1.获取用户名
        String username = request.getParameter("username");
        //2.调用service层判断用户名是否存在,这里简化

        Map<String,Object> map = new HashMap<>();

        if("tom".equals(username)){
            map.put("userExit",true);
            map.put("msg","此用户太受欢迎，请更换一个");
        }else{
            map.put("userExit",false);
            map.put("msg","用户名可用");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
