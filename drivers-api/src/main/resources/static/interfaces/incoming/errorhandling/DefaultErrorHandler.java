package app.car.appcarapi.interfaces.incoming.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DefaultErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ErrorData> messages = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> new ErrorData(fe.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ErrorResponse(messages);
    }
}
