package com.icss.codesmith.database.service

import com.icss.codesmith.template.info.AuthorInfo
import com.icss.codesmith.template.info.DateInfo
import com.icss.codesmith.template.info.ImportList
import com.icss.codesmith.template.info.GenerateParams
import com.icss.codesmith.template.util.DbMeta2TemplateInfoUtil
import com.icss.codesmith.template.util.GenerateUtil
import com.icss.codesmith.template.util.WordUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by XizeTian on 2016/12/19.
 * 根据velocity模板生成文件
 */
@Service
class GenerateTarget {
    @Autowired
    ProcessTable processTable
    @Autowired
    DbMeta2TemplateInfoUtil dbMeta2TemplateInfoUtil
    @Autowired
    GenerateUtil generateUtil

    /**
     * 根据指定表生成Domain
     * @param dbName
     * @param tableName
     */
    String generateDomain(String ftlName, String dbName, String tableName, GenerateParams generateParams) {
        String vmName = ftlName
        def table = processTable.getTable(dbName, tableName)

        def classInfo = dbMeta2TemplateInfoUtil.mysqlTableMeta2ClassInfo(table)
        def authorInfo = new AuthorInfo()
        def dateInfo = new DateInfo()
        def imports = new ImportList(classInfo.fields)

        def param = [
                "generateParams": generateParams,
                "classInfo"     : classInfo,
                "authorInfo"    : authorInfo,
                "dateInfo"      : dateInfo,
                "imports"       : imports,
                "word"          : new WordUtil()
        ]
        String result = generateUtil.generateString(param, vmName)

        return result
    }
}
