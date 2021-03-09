package cn.hmxz.modules.lit.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author: zhengying
 * @Date: 2020/12/23 11:36
 * @FileName: ServiceException
 * @Description: 服务异常
 */
public class ServiceException extends RuntimeException{


    private String code;

    public ServiceException(String code, String message, Throwable cause) {
        super(code + " - " + message, cause);
        this.code = code;
    }

    public ServiceException(String code, String message) {
        super(code + " - " + message);
        this.code = code;
    }

    public ServiceException(String message) {
        super(message);
    }

    public static ServiceException asServiceException(String code, String message) {
        return new ServiceException(code, message);
    }

    public static ServiceException asServiceException(String code, String message, Throwable cause) {
        if (cause instanceof ServiceException) {
            return (ServiceException) cause;
        }
        return new ServiceException(code, message, cause);
    }

    public static ServiceException asServiceException(String code, Throwable cause) {
        if (cause instanceof ServiceException) {
            return (ServiceException) cause;
        }
        return new ServiceException(code, getMessage(cause), cause);
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
