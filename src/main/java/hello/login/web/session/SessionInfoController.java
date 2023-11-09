package hello.login.web.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionInfoController {

//    @GetMapping("/session-info")
//    public String sessionInfo(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return "세션이 없음";
//        }
//
//        session.getAttribute()
//    }

}
