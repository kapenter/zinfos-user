package com.api.dingdang.user.constants;

public enum ResultEnums {


    SUCCESS("200", "success"),
            ;

    String code;
    String value;

    ResultEnums(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
