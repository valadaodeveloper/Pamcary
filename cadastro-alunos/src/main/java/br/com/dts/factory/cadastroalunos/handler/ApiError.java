package br.com.dts.factory.cadastroalunos.handler;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ApiError {
	
    private Integer status;

    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    
    @JsonInclude(Include.NON_NULL)
    private String messageException;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(Integer status) {
        this();
        this.status = status;
        this.message = "Erro inesperado";
    }

    public ApiError(Integer status, Throwable causa) {
        this();
        this.status = status;
        this.message = "Erro inesperado";
        if (causa != null) {
            this.messageException = causa.getLocalizedMessage();
        }
    }

    public ApiError(Integer status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public ApiError(Integer status, String message, Throwable causa) {
        this();
        this.status = status;
        this.message = message;
        if (causa != null) {
            this.messageException = causa.getLocalizedMessage();
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageException() {
        return messageException;
    }

    public void setMessageException(String messageException) {
        this.messageException = messageException;
    }

}
