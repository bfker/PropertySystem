package com.propertysys.user.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;
    boolean success;

    /**
     * 无参构造器
     */
    public Result() {
        this.code = 200;
        this.success = true;
    }


    /**
     * 有参构造器
     * @param data
     */
    public Result(T data) {
        this.code = 200;
        this.data = data;
        this.success = true;
    }

    /**
     * 有参构造器
     * @param resultCodeEnum
     */
    public Result(ResultCodeEnum resultCodeEnum) {
        this.success = false;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }


    /**
     * 有参构造器
     * @param resultCodeEnum
     * @param message
     */
    public Result(ResultCodeEnum resultCodeEnum, String message){
        this.success = false;
        this.code = resultCodeEnum.getCode();
        this.message = message;
    }


    /**
     * 通用返回成功（没有返回结果）
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(){
        return new Result();
    }

    /**
     * 返回成功（有返回结果）
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 通用返回失败
     * @param resultCode
     * @param <T>
     * @return
     */
    public static<T> Result<T> failure(ResultCodeEnum resultCode){
        return  new Result<T>(resultCode);
    }

    /**
     * 通用返回失败
     * @param resultCode
     * @param message
     * @param <T>
     * @return
     */
    public static<T> Result<T> failure(ResultCodeEnum resultCode,String message){
        return  new Result<T>(resultCode,message);
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

}

