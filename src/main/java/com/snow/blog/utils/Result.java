package com.snow.blog.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果类
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 私有构造方法
     */
    private Result() {
    }

    /**
     * 私有构造方法
     * @param code 状态码
     * @param message 返回消息
     * @param data 返回数据
     */
    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功", null);
    }

    /**
     * 成功返回结果
     * @param data 返回数据
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    /**
     * 成功返回结果
     * @param message 返回消息
     * @param data 返回数据
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    /**
     * 失败返回结果
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> failed() {
        return new Result<>(500, "操作失败", null);
    }

    /**
     * 失败返回结果
     * @param message 返回消息
     * @param <T> 数���泛型
     * @return 返回结果
     */
    public static <T> Result<T> failed(String message) {
        return new Result<>(500, message, null);
    }

    /**
     * 失败返回结果
     * @param code 状态码
     * @param message 返回消息
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> failed(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    /**
     * 参数验证失败返回结果
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> validateFailed() {
        return new Result<>(400, "参数验证失败", null);
    }

    /**
     * 参数验证失败返回结果
     * @param message 返回消息
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<>(400, message, null);
    }

    /**
     * 未授权返回结果
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> unauthorized() {
        return new Result<>(401, "暂未登录或token已经过期", null);
    }

    /**
     * 未授权返回结果
     * @param message 返回消息
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> unauthorized(String message) {
        return new Result<>(401, message, null);
    }

    /**
     * 禁止访问返回结果
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> forbidden() {
        return new Result<>(403, "没有相关权限", null);
    }

    /**
     * 禁止访问返回结果
     * @param message 返回消息
     * @param <T> 数据泛型
     * @return 返回结果
     */
    public static <T> Result<T> forbidden(String message) {
        return new Result<>(403, message, null);
    }
}
