package cn.hmxz.modules.lit.enumType;

/**
 * @Author: zhengying
 * @Date: 2020/12/26 14:49
 * @FileName: ErrorStatus
 * @Description: 错误枚举类
 */
public enum ErrorStatus {
    /**
     * 系统错误
     */
    INTERNAL_SERVER_ERROR("internal_server_error", "系统错误"),
    ILLEGAL_ARGUMENT("illegal_argument", "参数错误"),
    SERVICE_EXCEPTION("service_exception", "业务错误"),
    SQL_EXCEPTION("sql_error", "数据库异常"),
    ILLEGAL_DATA("illegal_data", "数据错误"),
    MULTIPART_TOO_LARGE("multipart_too_large", "文件太大"),
    ILLEGAL_STATE("illegal_state", "非法状态"),
    MISSING_ARGUMENT("missing_argument", "缺少参数"),
    ILLEGAL_ACCESS("illegal_access", "非法访问,没有认证"),
    UNAUTHORIZED("unauthorized", "权限不足"),
    METHOD_NOT_ALLOWED("method_not_allowed", "不支持的方法"),
    ILLEGAL_ARGUMENT_TYPE("illegal_argument_type", "参数类型错误");

    private final String value;
    private final String message;

    ErrorStatus(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String value() {
        return this.value;
    }

    public String getMessage() {
        return this.message;
    }
}
