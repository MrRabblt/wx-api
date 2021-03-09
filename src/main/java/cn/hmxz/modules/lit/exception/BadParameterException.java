package cn.hmxz.modules.lit.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author: zhengying
 * @Date: 2020/12/23 11:34
 * @FileName: BadParameterException
 * @Description: 参数校验异常
 */
public class BadParameterException extends RuntimeException{
    private String code;

    public BadParameterException(String code, String message, Throwable cause) {
        super(code + " - " + message, cause);
        this.code = code;
    }

    public BadParameterException(String code, String message) {
        super(code + " - " + message);
        this.code = code;
    }

    public BadParameterException(String message) {
        super(message);
    }

    public static BadParameterException asServiceException(String code, String message) {
        return new BadParameterException(code, message);
    }

    public static BadParameterException asServiceException(String code, String message, Throwable cause) {
        if (cause instanceof BadParameterException) {
            return (BadParameterException) cause;
        }
        return new BadParameterException(code, message, cause);
    }

    public static BadParameterException asServiceException(String code, Throwable cause) {
        if (cause instanceof BadParameterException) {
            return (BadParameterException) cause;
        }
        return new BadParameterException(code, getMessage(cause), cause);
    }

    private static String getMessage(Object obj) {
        if (null == obj) {
            return "";
        }
        if (obj instanceof Throwable) {
            StringWriter str = new StringWriter();
            ((Throwable) obj).printStackTrace(new PrintWriter(str));
            return str.toString();
        } else {
            return obj.toString();
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
