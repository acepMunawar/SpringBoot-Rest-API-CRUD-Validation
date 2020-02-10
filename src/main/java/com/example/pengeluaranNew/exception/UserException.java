package com.example.pengeluaranNew.exception;

import com.example.pengeluaranNew.enums.StatusCode;
import org.springframework.http.HttpStatus;     
import lombok.Data;

@Data
public class UserException extends RuntimeException
{
    private StatusCode code = null;
    private HttpStatus status = null;

    public UserException(){
        super();
    }

    public UserException(String message){
        super(message);
        this.code = code;
    }

    public UserException(String message, HttpStatus status)
    {
        super(message);
        this.status = status;
    }

    public UserException(String message, HttpStatus status, StatusCode code){
        super(message);
        this.status =status;
        this.code = code;
    }
}