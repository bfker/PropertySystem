package com.propertysys.user.utils;

public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    FAIL(400, "fail"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Authorization Failed"),//未认证
    NOT_FOUND(404, "Interface Not Exist"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),//服务器内部错误
    METHOD_NOT_ALLOWED(405,"Method Not Allowed"),

    /*参数错误:1001-1999*/
    PARAMS_IS_INVALID(1001, "Params is Invalid"),
    PARAMS_IS_BLANK(1002, "Params is Blank"),
    USER_IS_EXIST(1003,"User is Exist"),

    /* 文件上传错误 */
    FILE_UPLOAD_FAILED(2001, "File upload failed"),
    FILE_IS_EMPTY(2002, "File is empty");

    ;
    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
