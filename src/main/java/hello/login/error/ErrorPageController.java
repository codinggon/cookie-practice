package hello.login.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorPageController {

    @GetMapping("/error-ex")
    public void errorEx() {
        throw new RuntimeException("예외 발생!");
    }

//    @RequestMapping("/error-page/404")
//    public String errorPage404(HttpServletRequest request, HttpServletResponse
//            response) {
//
//        System.out.println("ErrorPageController.errorPage404");
//        return "error-page/404";
//    }
//    @RequestMapping("/error-page/500")
//    public String errorPage500(HttpServletRequest request, HttpServletResponse
//            response) {
//
//        System.out.println("ErrorPageController.errorPage500");
//        return "error-page/500";
//    }

}
