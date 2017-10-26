package org.vinci.codesmith.core.collector.database.domain

/**
 * Created by XizeTian on 2016/12/30.
 */
class DataBaseConf {
    String ipAddress
    int port
    String name
    String loginName
    String loginPassword
    DataBaseType type
    Map<String, String> tableMapping
}
