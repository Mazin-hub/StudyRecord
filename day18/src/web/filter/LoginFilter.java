package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //1.获取资源的请求路径
        String uri = request.getRequestURI();
        //2.判断是否时登录相关的资源,要注意排除 css、js、图片、验证码等资源
    // 为什么loginServlet内需要的其他资源不需要排除呢？难道是web下的资源与其直接相关的才要避开？
    //  并不是，在默认 DispatcherType.REQUEST 的情况下，一次请求，才拦截一次，转发是一次请求，这次请求中包含访问多个资源，那也只拦截一次
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("checkCodeServlet")){
            // 包含，用户就是想登录，放行
            chain.doFilter(req, resp);
        }else{
            //不包含，需要验证用户是否已登录
            //3.从session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                // 已经登录
                chain.doFilter(req, resp);
            }else{
                //没有登录，跳转
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
