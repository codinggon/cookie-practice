package hello.login.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(Member member, Model model) {
//        model.addAttribute("member",new Member());
        return "member/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "member/addMemberForm";
        }

        memberRepository.save(member);
        System.out.println("save member = " + member);
        return "redirect:/";
    }





}
