package com.icss.codesmith.template.util

/**
 * 下划线变量转换为驼峰变量
 * Created by XizeTian on 2016/12/19.
 */
class UnderlineField2HumpField {
    String underlineField;
    String targetValue;

    UnderlineField2HumpField(String underlineField) {
        this.underlineField = underlineField;
        this.targetValue = "";
    }

    String get() {
        boolean nextIsToUpper = false;
        for (ch in underlineField) {
            def tmpCh = ch;
            if (tmpCh == "_") {
                nextIsToUpper = true;
                continue
            } else if (nextIsToUpper) {
                tmpCh = ch.toUpperCase()
                nextIsToUpper = false
            }
            targetValue += tmpCh;
        }
        return targetValue;
    }
}
