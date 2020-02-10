package com.example.pengeluaranNew.exception;

import com.example.pengeluaranNew.util.UserRestUtil;
import com.example.pengeluaranNew.vo.UserResultVO;
import com.example.pengeluaranNew.enums.StatusCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalDefaultExceptionHandler{
    private static final Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    public ResponseEntity<?> notValidHandler(HttpServletRequest req, MethodArgumentNotValidException ex){
        log.error(String. format("%s : Caught in Global Exception Handler for req: %s", ex.getLocalizedMessage(), req.getRequestURL()));
            String errors;
                List<String> errorList = new ArrayList<String>();
        for(FieldError error : ex.getBindingResult().getFieldErrors())
        {
            errorList.add(error.getDefaultMessage());
        }        
            errors = errorList.stream().collect(Collectors.joining(","));
                UserResultVO restResponseVO = new UserResultVO();
                restResponseVO.setResults(errors);
                restResponseVO.setMessage("ERROR");
                restResponseVO.setStatus(400);
            return new ResponseEntity<>(restResponseVO, HttpStatus.BAD_REQUEST);    
    }

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<?> defaultErrorHandler(HttpServletRequest req, Exception e){
        log.error(String.format("%s ; Caught in Global Exception Handler for req : %s", e.getLocalizedMessage(), req.getRequestURL()));
        log.error("ERROR CAUSE :", e );

            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

            UserResultVO restResponseVO = new UserResultVO();
                restResponseVO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                restResponseVO.setMessage(StatusCode.ERROR.name());
                restResponseVO.setResults(e.getMessage());
            return new ResponseEntity<>(restResponseVO, status);
    }

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<?> defaultErrorHandler(HttpServletRequest req, UserException e ){
        log.error(String.format("%s : Caugth in Global Exception Handler for req: %s", e.getLocalizedMessage(),req.getRequestURL()));
        log.error("TRANSACTION EXCEPTION CAUSE :", e);

        HttpStatus status;
        if(!StringUtils.isEmpty(e.getStatus()))
        {
            status = e.getStatus();
        }
        else
        {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        StatusCode code;
        if(!StringUtils.isEmpty(e.getCode()))
        {
            code = e.getCode();
        }else{
            code = StatusCode.ERROR;
        }

        UserResultVO restResponseVO = new UserResultVO();
        restResponseVO.setResults(e.getMessage());
        restResponseVO.setMessage(code.name());
        restResponseVO.setStatus(status.value());
        return new ResponseEntity<>(restResponseVO, status);
    }

}