package hello.login.web.filter;

import hello.login.web.session.SessionConst;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheckFilter implements Filter {

    private static final String[] whitelist = {"/","/members/add","/login","/logout","/css/*"};


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        try {
            if (!isLoginCheckPath(requestURI)) {
                System.out.println("인증 체크 실행 >> requestURI = " + requestURI);

                HttpSession session = httpRequest.getSession(false);
                if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
                    System.out.println("미인증 사용자 요청 : " + requestURI);
                    //로그인으로 redirect
                    httpServletResponse.sendRedirect("/login?redirectURL=" + requestURI);
                    return;
                }
            }
            chain.doFilter(request, response);

        } catch (Exception e) {

            e.printStackTrace(); //예외 로깅 가능, 톰캣까지 예외를 보내줘야함.
            throw e;
        }finally {
            System.out.println("LoginCheckFilter. 종료");
        }


    }

    /**
     * whitelist 확인
     */
    private boolean isLoginCheckPath(String requestUrl) {
        return PatternMatchUtils.simpleMatch(whitelist, requestUrl);
    }

}
