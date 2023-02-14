package br.com.tipotelas.controllers.exceptions;

import com.mongodb.MongoWriteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiException> haddlerMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {

        ApiException apiException = ApiException.builder()
                .title("Requisição inválida")
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now()).build();

        log.error("Status Http: {}, message: {}\n", HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }

    @ExceptionHandler(value = {MongoWriteException.class})
    public ResponseEntity<ApiException> haddlerMongoWriteException(MongoWriteException e, HttpServletRequest request) {

        ApiException apiException = ApiException.builder()
                .title("Requisição inválida")
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now()).build();

        log.error("Status Http: {}, message: {}\n", HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity<ApiException> haddlerMissingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest request) {

        ApiException apiException = ApiException.builder()
                .title("Requisição inválida")
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now()).build();

        log.error("Status Http: {}, message: {}\n", HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }
}
