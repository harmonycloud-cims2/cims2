package hk.health.common.base;

import hk.health.common.enums.ErrorMessageEnum;

/**
 * @Usage: 返回结果集封装
 * @Author: gjq
 * @Date: 2019/3/21 4:33 PM
 */
public class BaseResult {
    private static final long serialVersionUID = 1L;

    private static final Integer CODE = 0;

    private Integer code;

    private String msg;

    private Boolean success;

    private Object data;

    private Integer count;

    public BaseResult() {

    }

    public BaseResult(Integer code, boolean success) {
        this.code = code;
        this.success = success;
    }

    public BaseResult(Integer code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public BaseResult(Integer code, Object data, boolean success) {
        this.code = code;
        this.data = data;
        this.success = success;
    }

    public BaseResult(Integer code, String msg, Boolean success, Object data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
        this.count = count;
    }

    public BaseResult(Integer code, String msg, Object data, boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public BaseResult(Object data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public static BaseResult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static BaseResult error(String msg) {
        return error(500, msg);
    }

    public static BaseResult error(ErrorMessageEnum errorMessageEnum) {
        return error(500, errorMessageEnum.getMsg());
    }

    public static BaseResult error(ErrorMessageEnum errorMessageEnum, String msg) {
        return error(500, errorMessageEnum.getMsg() + ":" + msg);
    }

    public static BaseResult error(Integer code, String msg) {
        return new BaseResult(code, msg, false);
    }

    public static BaseResult ok(String msg) {
        return new BaseResult(CODE, msg, true);
    }

    public static BaseResult ok(Object result) {
        return new BaseResult(CODE, result, true);
    }

    public static BaseResult ok(Object result, Integer count) {
        return new BaseResult(CODE, "success", true, result, count);
    }

    public static BaseResult ok(String msg, Object result) {
        return new BaseResult(CODE, msg, result, true);
    }

    public static BaseResult ok() {
        return new BaseResult(CODE, true);
    }

    public static BaseResult exception(Integer code, Object data) {
        return new BaseResult(code, "", data, false);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCount() {
        return count;
    }

    public BaseResult setCount(Integer count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                ", result=" + data +
                '}';
    }
}
