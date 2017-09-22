package com.icss.codesmith.template

/**
 * Created by XizeTian on 2016/12/19.
 */
enum JavaType {
    STRING("String"),
    INT("int"),
    LONG("long"),
    J_DATE_TIME("JDateTime"),
    BYTE("byte"),
    BOOLEAN("boolean")

    private String value

    private JavaType(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }
}