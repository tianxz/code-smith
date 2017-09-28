package com.icss.codesmith.template.util
/**
 * Created by XizeTian on 2016/12/19.
 */
class WordUtil {
    private String word

    private WordUtil() {}

    static inValue( String word ) {
        WordUtil wordUtil = new WordUtil()
        wordUtil.word = word
        return wordUtil
    }

    /**
     * 单词首字母替换为小写
     * @param word
     * @return
     */
    WordUtil firstToLower() {
        word = word.substring( 0, 1 ).toLowerCase() + word.substring( 1 )
        return this
    }

    /**
     * 单词首字母替换为大写
     * @param word
     * @return
     */
    WordUtil firstToUp() {
        word = word.substring( 0, 1 ).toUpperCase() + word.substring( 1 )
        return this
    }

    WordUtil toUpper() {
        word = word.toUpperCase()
        return this
    }

    /**
     * 下划线变量替换为驼峰变量
     * @param word
     * @return
     */
    WordUtil UnderlineField2HumpField() {
        def targetValue = ''
        boolean nextIsToUpper = false
        for ( ch in word ) {
            def tmpCh = ch
            if ( tmpCh == "_" ) {
                nextIsToUpper = true
                continue
            } else if ( nextIsToUpper ) {
                tmpCh = ch.toUpperCase()
                nextIsToUpper = false
            }
            targetValue += tmpCh
        }
        word = targetValue
        return this
    }

    String outValue() {
        return word
    }

    @Override
    String toString() {
        return word
    }
}
