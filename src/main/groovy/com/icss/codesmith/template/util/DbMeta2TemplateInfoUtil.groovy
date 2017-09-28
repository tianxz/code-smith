package com.icss.codesmith.template.util

import com.icss.codesmith.database.meta.Table
import com.icss.codesmith.template.info.ClassInfo
import com.icss.codesmith.template.info.FieldInfo
import com.icss.codesmith.utils.PropertiesUtil
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

    ClassInfo mysqlTableMeta2ClassInfo( Table table ) {
        ClassInfo classInfo = new ClassInfo()
        classInfo.name = WordUtil.inValue( table.tableName ).UnderlineField2HumpField().firstToUp().outValue()
        for ( column in table.columns ) {
            FieldInfo fieldInfo = new FieldInfo()
            fieldInfo.describe = StringUtil.isEmpty( column.columnComment ) ? null : column.columnComment
            fieldInfo.name = WordUtil.inValue( column.columnName.toLowerCase() ).UnderlineField2HumpField().outValue()
            fieldInfo.sqlName = WordUtil.inValue( column.columnName ).toUpper().outValue()
            String javaType = propUtil.getMysqlDataProp().getProperty( column.dataType )
            if ( javaType != null ) {
                fieldInfo.javaType = javaType
            } else {
                throw new RuntimeException( "不支持MYSQL ${ column.dataType } 类型, 请在 mysqldata.properties 文件中添加类型映射" )
            }
            classInfo.fields.add( fieldInfo )
            classInfo.comment = table.tableComment
        }
        return classInfo
    }
}