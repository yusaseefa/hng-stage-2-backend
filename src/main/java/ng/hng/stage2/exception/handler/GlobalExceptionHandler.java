package ng.hng.stage2.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> dataValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        Map<String, String> errMap = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(new Consumer<ObjectError>() {
            @Override
            public void accept(ObjectError error) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errMap.put(fieldName, errorMessage);
            }
        });
        errors.put("message", errMap);
        errors.put("errorType", "dataValidation");
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ArithmeticException.class)
    public Object arithmeticOperation(ArithmeticException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", "ArithmeticOperation");
        errors.put("message", "The arithmetic operation you are trying to perform is invalid.");
        errors.put("code" , Integer.toString(HttpStatus.BAD_REQUEST.value()));
        return errors;
    }
}
