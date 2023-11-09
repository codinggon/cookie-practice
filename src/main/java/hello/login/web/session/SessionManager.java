package hello.login.web.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {

    public static final String MY_SESSION_NAME = "mySessionId";
    //동시성 이슈
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    /**
     * 세션 생성
     * session id 생성
     */
    public void createSession(Object value, HttpServletResponse response) {

        //session id 생성
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);


        //쿠키 생성
        Cookie mySessionCookie = new Cookie(MY_SESSION_NAME, sessionId);
        response.addCookie(mySessionCookie);

    }

    /**
     * 세션 조회
     */
    public Object getSession(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(MY_SESSION_NAME)) {
                return sessionStore.get(cookie.getValue());
            }
        }

        Cookie sessionCookie =
                getFindCookie(request, MY_SESSION_NAME);

        if (sessionCookie == null) {
            return null;
        }

        return sessionStore.get(sessionCookie.getValue());
    }


    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = getFindCookie(request, MY_SESSION_NAME);
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    private static Cookie getFindCookie(HttpServletRequest request, String mySessionName) {
        return Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals(mySessionName)).findFirst().orElse(null);
    }


}
