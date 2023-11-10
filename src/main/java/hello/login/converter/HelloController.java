package hello.login.converter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");//문자타입
        Integer intValue = Integer.valueOf(data); //숫자 타입변경

        return "ok";
    }




}
