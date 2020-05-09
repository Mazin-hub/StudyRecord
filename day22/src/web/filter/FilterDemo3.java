package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 服务器关闭后，Filter对象被销毁，如果服务器正常关闭，则执行destroy()
     * 用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("destroy。。。。");
    }

    /**
     * 每一次请求 【被拦截资源】 时执行。
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器启动后，创建Filtet对象，调用init()方法
     * 用于加载资源
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init....");
    }

}
