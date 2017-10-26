package org.vinci.codesmith.core.template.handler

/**
 * 逻辑代码类型处理
 * code logic
 * Created by XizeTian on 2017/10/25.
 */
class CLHandler {
    enum CLType {
        /*缺省值*/
        NULL(0),

        /*数据模型代码*/
                DOMAIN(10000),
        DOMAIN_META(10001),

        /*数据库访问代码*/
                DAO(30000),
        QUERY_DEPICT(30001),
        UPDATE_DEPICT(30002),

        /*视图控制器代码*/
                CONTROLLER(60000),

        /*业务逻辑代码*/
                SERVICE(60000),

        /*工具类代码*/
                UTIL(70000)

        private int numCode

        private CodeLogicHandler(int numCode) {
            this.numCode = numCode
        }
    }
}
