package hello.login.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExControllerAdvice {


    @ExceptionHandler
    public ResponseEntity<ErrorResult> illegalException(IllegalArgumentException e) {
        System.out.println("e = " + e);
        return ResponseEntity.badRequest().body(new ErrorResult("BAD", e.getMessage()));
    }



}
