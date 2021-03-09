package cn.hmxz.modules.lit.exception;

import cn.hmxz.modules.lit.entity.io.response.BlackHorseResponse;
import cn.hmxz.modules.lit.enumType.ErrorStatus;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhengying
 * @Date: 2020/12/26 13:33
 * @FileName: ExceptionHandler
 * @Description: 异常处理
 */
@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {


    /**
     * 构建返回错误
     *
     * @param status
     * @param exception
     * @param data
     * @return
     */
    private BlackHorseResponse failure(ErrorStatus status, Exception exception, Object data) {
        String message = null;
        if (exception != null) {
            message = String.format("%s : %s", status.getMessage(), exception.getMessage());
        }
        return BlackHorseResponse.buildFailure(status.value(), message, data);
    }

    /**
     * 构建返回错误
     *
     * @param status
     * @param data
     * @return
     */
    private BlackHorseResponse failure(ErrorStatus status, Object data) {
        return failure(status, null, data);
    }

    /**
     * 构建返回错误
     *
     * @param status
     * @param exception
     * @return
     */
    private BlackHorseResponse failure(ErrorStatus status, Exception exception) {
        return failure(status, exception, null);
    }

    /**
     * 构建返回错误
     *
     * @param status
     * @return
     */
    private BlackHorseResponse failure(ErrorStatus status) {
        return BlackHorseResponse.buildFailure(status);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ConstraintViolationException.class)
    public BlackHorseResponse handleValidationException(ConstraintViolationException e) {
        log.error(ErrorStatus.ILLEGAL_DATA.getMessage(), e);
        List<Map<String, Object>> fields = new ArrayList<>();
        for (ConstraintViolation<?> cv : e.getConstraintViolations()) {
            // get the last node of the violation
            String fieldName = null;
            for (Path.Node node : cv.getPropertyPath()) {
                fieldName = node.getName();
            }
            String message = cv.getMessage();
            Map<String, Object> field = new HashMap<>();
            field.put("field", fieldName);
            field.put("message", message);
            fields.add(field);
        }
        return failure(ErrorStatus.ILLEGAL_DATA, fields);
    }
    /**
     * AccessDeniedException
     *
     * @param e the e
     * @return R
     *//*
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public BlackHorseResponse handleAccessDeniedException(AccessDeniedException e) {
        String msg = SpringSecurityMessageSource.getAccessor().getMessage("AbstractAccessDecisionManager.accessDenied", e.getLocalizedMessage());
        log.error("拒绝授权异常信息 ex={}", msg, e);
        return failure(ErrorStatus.ILLEGAL_ACCESS, msg);
    }*/

    @ResponseBody
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleBindException(BindException e) {
        log.error(ErrorStatus.ILLEGAL_DATA.getMessage(), e);
        List<Map<String, Object>> fields = new ArrayList<>();
        for (FieldError error : e.getFieldErrors()) {
            Map<String, Object> field = new HashMap<>();
            field.put("field", error.getField());
            field.put("message", error.getDefaultMessage());
            fields.add(field);
        }
        return failure(ErrorStatus.ILLEGAL_DATA, fields);
    }

    @ResponseBody
    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleMultipartException() {
        return failure(ErrorStatus.MULTIPART_TOO_LARGE);
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(ErrorStatus.ILLEGAL_ARGUMENT.getMessage(), e);
        return failure(ErrorStatus.ILLEGAL_ARGUMENT, e);
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleMissingServletRequestParameterException(
            MissingServletRequestParameterException e) {
        log.error(ErrorStatus.MISSING_ARGUMENT.getMessage(), e);
        return failure(ErrorStatus.MISSING_ARGUMENT, e);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleMethodArgumentTypeMismatchExceptionException(
            MethodArgumentTypeMismatchException e) {

        log.error(ErrorStatus.ILLEGAL_ARGUMENT_TYPE.getMessage(), e);
        return failure(ErrorStatus.ILLEGAL_ARGUMENT_TYPE, e);
    }

    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public BlackHorseResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {

        log.error(ErrorStatus.METHOD_NOT_ALLOWED.getMessage(), e);
        return failure(ErrorStatus.METHOD_NOT_ALLOWED, e);
    }

    @ResponseBody
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleIllegalStateException(IllegalStateException e) {
        log.warn("exception", e);
        return failure(ErrorStatus.ILLEGAL_STATE, e);
    }

    @Order(1)
    @ResponseBody
    @ExceptionHandler({BadParameterException.class})
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleBadParameterException(BadParameterException e) {
        log.error(ErrorStatus.ILLEGAL_ARGUMENT.getMessage(), e);
        if (e.getCode() == null) {
            return failure(ErrorStatus.ILLEGAL_ARGUMENT, e);
        } else {
            return BlackHorseResponse.buildFailure(e.getCode(), e.getMessage());
        }
    }

    @Order(2)
    @ResponseBody
    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.OK)
    public BlackHorseResponse handleServiceException(ServiceException e) {
        log.error(ErrorStatus.SERVICE_EXCEPTION.getMessage(), e);
        if (e.getCode() == null) {
            return failure(ErrorStatus.SERVICE_EXCEPTION, e);
        } else {
            return BlackHorseResponse.buildFailure(e.getCode(), e.getMessage());
        }
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataAccessException.class)
    public BlackHorseResponse handleRRException(DataAccessException e) {
        log.error(ErrorStatus.SQL_EXCEPTION.getMessage(), e);
        return BlackHorseResponse.buildFailure(ErrorStatus.SQL_EXCEPTION.getMessage(), "data access exceptions");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DuplicateKeyException.class)
    public BlackHorseResponse handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(ErrorStatus.SQL_EXCEPTION.getMessage(), e);
        return BlackHorseResponse.buildFailure(ErrorStatus.SQL_EXCEPTION.getMessage(), "数据库中已存在该记录");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public BlackHorseResponse handleSQLException(SQLException e) {
        log.error(ErrorStatus.SQL_EXCEPTION.getMessage(), e);
        return BlackHorseResponse.buildFailure(ErrorStatus.SQL_EXCEPTION.getMessage(), "SQL数据存在异常错误");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CommunicationsException.class)
    public BlackHorseResponse handleCommunicationsException(final CommunicationsException e) {
        log.error(ErrorStatus.SQL_EXCEPTION.getMessage(), e);
        return BlackHorseResponse.buildFailure(ErrorStatus.SQL_EXCEPTION.getMessage(), "数据连接丢失");
    }

    @Order(Ordered.LOWEST_PRECEDENCE)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BlackHorseResponse handleException(Exception e) {
        e.printStackTrace();
        log.error(ErrorStatus.INTERNAL_SERVER_ERROR.getMessage(), e);
        return failure(ErrorStatus.INTERNAL_SERVER_ERROR, e);
    }
}
