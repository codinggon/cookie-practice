package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

//    @GetMapping("/")
    public String homeIndex() {
        return "home";
    }

    @GetMapping("/")
    public String homeLogin(Member loginMember, Model model) {

        //세션 관리자에 저장된 정보 조회
//        Member session = (Member) sessionManager.getSession(request);
        //false 로그인 전에 세션을 생성하면 안되므로
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return "home";
//        }
//
//        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);


        //로그인

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member",loginMember);
        return "loginHome";
    }

}















