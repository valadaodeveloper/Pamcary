package br.com.dts.factory.cadastroalunos.handler;

import java.net.UnknownHostException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiEntityExceptionHandler {

    private static final Logger log = LogManager.getLogger(ApiEntityExceptionHandler.class);

    @ExceptionHandler({ ApiException.class, DataIntegrityViolationException.class })
    ResponseEntity<Object> handleGndiPushnotificationApiErrorException(ApiException ex) {
        log.warn("Erro de negócio tratado pela API", ex);
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler({ UnknownHostException.class, DataAccessResourceFailureException.class })
    ResponseEntity<Object> handleDefaultException(Exception ex) {
        log.error("Erro na AWS ou de acesso a dados", ex);
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex));
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handle(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            if (strBuilder.length() > 0) {
                strBuilder.append("; ");
            }
            strBuilder.append(violation.getPropertyPath()).append(" ").append(violation.getMessage());
        }
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), strBuilder.toString(), ex));
    }

    @ExceptionHandler(value = { MissingServletRequestParameterException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handle(MissingServletRequestParameterException ex) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(ex.getMessage());
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), strBuilder.toString(), ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }
}
