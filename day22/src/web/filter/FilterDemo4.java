package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*  访问具体资源路径，拦截  */
//@WebFilter("/index.jsp")
/*  访问目录下的资源路径，拦截    */
//@WebFilter("/user/*")
/*   后缀名拦截   */
//@WebFilter("*.jsp")
public class FilterDemo4 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}
