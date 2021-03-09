package cn.hmxz.modules.lit.entity.io.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 16:40
 * @FileName: BlackHorseResponse
 * @Description: 返回信息
 */
@Data
public class BlackHorseResponse<T> implements Serializable {
    private boolean success;
    private String message;
    private String error;
    private T data;

    public static <T> BlackHorseResponse<T> build(boolean success, String message, T data) {
        return build(success, (String)null, message, data);
    }

    public static <T> BlackHorseResponse<T> build(boolean success, String error, String message, T data) {
        BlackHorseResponse<T> result = new BlackHorseResponse<>();
        result.setSuccess(success);
        result.setError(error);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> BlackHorseResponse<T> buildSuccess(T data) {
        return buildSuccess((String)null, data);
    }

    public static <T> BlackHorseResponse<T> buildFailure(T data) {
        return buildFailure("未知错误", data);
    }

    public static <T> BlackHorseResponse<T> buildSuccess(String message) {
        return buildSuccess(message, (Object)null);
    }

    public static <T> BlackHorseResponse<T> buildFailure(String message) {
        return buildFailure("unknown error", message);
    }

    public static <T> BlackHorseResponse buildSuccess(String message, T data) {
        return build(Boolean.TRUE, message, data);
    }

    public static <T> BlackHorseResponse<T> buildFailure(String message, T data) {
        return build(Boolean.FALSE, message, data);
    }

    public static BlackHorseResponse buildFailure(String error, String message) {
        return build(Boolean.FALSE, error, message, (Object)null);
    }

    public static <T> BlackHorseResponse<T> buildFailure(String error, String message, T data) {
        return build(Boolean.FALSE, error, message, data);
    }

    public static <T> ResultBuilder<T> builder() {
        return new ResultBuilder();
    }

    @Override
    public String toString() {
        return "BlackHorseResponse(success=" + this.isSuccess() + ", message=" + this.getMessage() + ", error=" + this.getError() + ", data=" + this.getData() + ")";
    }

    public BlackHorseResponse() {
    }

    public BlackHorseResponse(boolean success, String message, String error, T data) {
        this.success = success;
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public BlackHorseResponse<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public BlackHorseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getError() {
        return this.error;
    }

    public BlackHorseResponse<T> setError(String error) {
        this.error = error;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public BlackHorseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static class ResultBuilder<T> {
        private boolean success;
        private String message;
        private String error;
        private T data;

        ResultBuilder() {
        }

        public ResultBuilder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public ResultBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResultBuilder<T> error(String error) {
            this.error = error;
            return this;
        }

        public ResultBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public BlackHorseResponse<T> build() {
            return new BlackHorseResponse(this.success, this.message, this.error, this.data);
        }

        @Override
        public String toString() {
            return "BlackHorseResponse.ResultBuilder(success=" + this.success + ", message=" + this.message + ", error=" + this.error + ", data=" + this.data + ")";
        }
    }
}
