package org.vinci.codesmith.core.plugin.scurd

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.vinci.codesmith.core.code.BuitIn
import org.vinci.codesmith.core.collector.base.dto.GenDto
import org.vinci.codesmith.core.collector.database.domain.Table
import org.vinci.codesmith.core.plugin.scurd.info.AuthorInfo
import org.vinci.codesmith.core.plugin.scurd.info.DateInfo
import org.vinci.codesmith.core.plugin.scurd.info.ImportList
import org.vinci.codesmith.core.plugin.scurd.info.PackageInfo

/**
 * Created by XizeTian on 2017/10/27.
 */
@Component
class BuitInForMapper extends BuitIn {
    private final String                  BEAN_NAME     = 'mapper'
    private final String                  TEMPLATE_NAME = 'scurd/mapper'
    @Autowired
    private       DbMeta2TemplateInfoUtil dbMeta2TemplateInfoUtil

    @Override
    Map buildContext(GenDto genDto) {
        def classInfo = dbMeta2TemplateInfoUtil.mysqlTableMeta2ClassInfo((Table) genDto.dataSource, genDto.ownerConf.aliasNameMap)
        def authorInfo = new AuthorInfo()
        def dateInfo = new DateInfo()
        def imports = new ImportList(classInfo.fields)
        def packageInfo = new PackageInfo(fullName: super.buildPackageName())
        def ext = [
                "domainPackage": "${super.buildBasePackageName()}.domain",
                "daoPackage"   : "${super.buildBasePackageName()}.dao",
                'primaryKey'   : genDto.primaryKey
        ]

        return [
                "ext"        : ext,
                "packageInfo": packageInfo,
                "classInfo"  : classInfo,
                "authorInfo" : authorInfo,
                "dateInfo"   : dateInfo,
                "imports"    : imports
        ]
    }

    @Override
    String buildDirName() {
        return ''
    }

    @Override
    String buildTemplateName() {
        return TEMPLATE_NAME
    }

    @Override
    String getBeanName() {
        return BEAN_NAME
    }

    @Override
    String buildFileName() {
        String fileName = super.buildFileName()
        return "${fileName}-mapper"
    }
}