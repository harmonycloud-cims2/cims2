package hk.health.common.enums;

/**
 * @Usage: 错误代码枚举
 * @Author: gjq
 * @Date: 2019/3/25 3:26 PM
 */
public enum ErrorMessageEnum {
    USER_NOT_LOGIN(401, "User not login or timeout", "用户未登录或登录超时"),
    TOKEN_ERROR(401, "Token invalid", "Token不合法或已失效"),
    ERROR(500, "Error", "程序异常"),
    EXIST(500, "Existed", "已存在"),
    NOT_EXIST(500, "Not existed", "不存在"),
    NOT_NULL(500, "Not null", "不为空"),
    NETWORK_ERROR(500, "Network Error", "网络错误"),
    ;

    private final int code;
    private final String zhMsg;
    private final String enMsg;

    ErrorMessageEnum(int code, String enMsg, String zhMsg) {
        this.code = code;
        this.zhMsg = zhMsg;
        this.enMsg = enMsg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 获取当下语言的返回信息
     *
     * @return
     */
    public String getMsg() {
        return zhMsg;
    }

    public String getZhMsg() {
        return zhMsg;
    }

    public String getEnMsg() {
        return enMsg;
    }
}
