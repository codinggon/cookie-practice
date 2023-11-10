package hello.login.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;


public class LogFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("LoginFilter.doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        StringBuffer requestURL = httpRequest.getRequestURL();
        String uuid = UUID.randomUUID().toString();

        try {
            System.out.println("requestURL = " + requestURL);
            System.out.println("uuid = " + uuid);
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            String format = String.format("response : %s , %s", uuid, requestURL);
            System.out.println("format = " + format);
        }

    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter.destroy");
    }
}
