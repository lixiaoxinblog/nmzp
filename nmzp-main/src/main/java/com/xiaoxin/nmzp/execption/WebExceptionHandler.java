package com.xiaoxin.nmzp.execption;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class WebExceptionHandler {


    @ExceptionHandler(value = ConstraintViolationException.class)
    public AjaxResult constraintViolationExceptionHandler(ConstraintViolationException e) {
        ConstraintViolation<?> constraintViolation = e.getConstraintViolations().stream().findFirst().get();
        return AjaxResult.error(HttpStatus.ERROR, constraintViolation.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public AjaxResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().stream().findFirst().get();
        return AjaxResult.error(HttpStatus.ERROR,objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    public AjaxResult serviceExceptionHandler(ServiceException e){
        return AjaxResult.error(HttpStatus.ERROR, e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public AjaxResult ExceptionHandler(Exception e) {
       e.printStackTrace();
        //todo 改
        return AjaxResult.error(HttpStatus.ERROR, "系统错误");
    }

}
