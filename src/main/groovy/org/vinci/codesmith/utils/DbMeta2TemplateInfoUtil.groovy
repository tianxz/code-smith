package org.vinci.codesmith.utils

import org.vinci.codesmith.gen.database.meta.Table
import org.vinci.codesmith.template.info.ClassTemplateInfo
import org.vinci.codesmith.template.info.FieldTemplateInfo
import jodd.util.StringUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * 转换数据库表信息为ClassInfo
 * Created by XizeTian on 2016/12/19.
 */
@Component
class DbMeta2TemplateInfoUtil {
    @Autowired
    PropertiesUtil propUtil

    ClassTemplateInfo mysqlTableMeta2ClassInfo(Table table) {
        ClassTemplateInfo classInfo = new ClassTemplateInfo()

        classInfo.name = WordUtil
                .of(table.customerName ? table.customerName : table.tableName)
                .toLower()
                .UnderlineField2HumpField()
                .firstToUp()
                .outValue()

        classInfo.sqlName = table.tableName.toUpperCase()
        for (column in table.columns) {
            FieldTemplateInfo fieldInfo = new FieldTemplateInfo()
            fieldInfo.describe = StringUtil.isEmpty(column.columnComment) ? null : column.columnComment
            fieldInfo.name = WordUtil.of(column.columnName.toLowerCase()).UnderlineField2HumpField().outValue()
            fieldInfo.sqlName = WordUtil.of(column.columnName).toUpper().outValue()
            String javaType = propUtil.getMysqlDataProp().getProperty(column.dataType)
            if (javaType != null) {
                fieldInfo.javaType = javaType
            } else {
                throw new RuntimeException("不支持MYSQL ${column.dataType} 类型, 请在 mysqldata.properties 文件中添加类型映射")
            }
            classInfo.fields.add(fieldInfo)
            classInfo.comment = table.tableComment
        }
        return classInfo
    }
}