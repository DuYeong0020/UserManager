package kr.flab.usermanager.common.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

    // 200 - 성공
    // 300 - redirect
    // 400 - client error
    // 500 - server error
    @ResponseBody   // application/json
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResult exHandle(Exception e) {
        return new ErrorResult("500", e.getMessage());
    }

//    {
//        "code" : "CODE_1",

//        "message" : "없는 유저입니다"
//    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult exParameter(MethodArgumentNotValidException e) {
        return new ErrorResult("400", e.getMessage());
    }


    // Exception
    // Checked vs UnChecked (Runtime)

}
