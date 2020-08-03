package exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice // 해당 객체가(CommonExceptionAdvice) 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@Log4j
public class CommonExceptionAdvice {

    @ExceptionHandler(Exception.class) // 해당 메서드가 () 안에 들어가는 예외 타입을 처리한다. except() 메서드는 모든 Exception 을 처리.
    public String except(Exception ex, Model model) {
        log.info("Exception = " + ex.getMessage());
        model.addAttribute("exception", ex);
        log.error(model);
        return "error/error_page";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex){
        return "error/custom404";
    }
}
