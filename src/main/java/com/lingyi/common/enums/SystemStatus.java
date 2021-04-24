package com.lingyi.common.enums;

public enum SystemStatus {

    SUCCESS("0","成功"),
    SYSTEM_ERROR("0001","系统错误"),
    ;

    SystemStatus(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
