package tacos.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    protected String handleConflict(Exception ex) {
        return "err";
    }

}
