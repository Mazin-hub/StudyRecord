package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 浏览器直接请求资源（DispatcherType.REQUEST）时，该过滤器 拦截
 * 对比ServletDemo3

@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)

/**
  只有转发访问index.jsp时，该过滤器才会执行
@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
*/

/**
 * 浏览器直接请求资源 或 转发访问index.jsp时，过滤器才会执行
 */
//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo5 implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
