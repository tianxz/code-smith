package com.icss.codesmith.database.service

import com.icss.codesmith.database.domain.DataBaseConf
import com.icss.codesmith.database.domain.OneKeyConf
import com.icss.codesmith.template.info.AuthorInfo
import com.icss.codesmith.template.info.DateInfo
import com.icss.codesmith.template.info.GenerateParams
import com.icss.codesmith.template.info.ImportList
import com.icss.codesmith.template.util.DbMeta2TemplateInfoUtil
import com.icss.codesmith.template.util.GenerateUtil
import com.icss.codesmith.template.util.WordUtil
import com.icss.codesmith.utils.UserDataSourceUtil
import jodd.io.FileNameUtil
import jodd.io.FileUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by XizeTian on 2016/12/19.
 * 根据velocity模板生成文件
 */
@Service
class GenerateService {
    @Autowired
    TableService            processTable
    @Autowired
    DbMeta2TemplateInfoUtil dbMeta2TemplateInfoUtil
    @Autowired
    GenerateUtil            generateUtil
    @Autowired
    UserDataSourceUtil      httpSession

    /**
     * 根据指定表生成Domain
     * @param dbName
     * @param tableName
     */
    String generateCode(String ftlName, String dbName, String tableName, GenerateParams generateParams) {
        return generateCodeMap(ftlName, dbName, tableName, generateParams).code
    }

    Map generateCodeMap(String ftlName, String dbName, String tableName, GenerateParams generateParams) {
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

        return [param: param, code: result]
    }

    void oneKeyGenerate(OneKeyConf conf) {
        def packageDir = conf.packageName.replace(".", "/")
        def file = new File(FileNameUtil.concat(conf.dirPath, packageDir))
        if (!file.exists()) {
            file.mkdirs()
        }

        String domainDirName = 'domain'
        String daoDirName = 'dao'
        String controllerDirName = 'controller'
        String mateDirName = 'domain/meta'
        DataBaseConf dbConf = httpSession.getDataBaseConf()

        GenerateParams gp = new GenerateParams()
        gp.packageInfo = conf.packageName
        gp.daoPackageInfo = conf.packageName + '.dao'
        gp.domainPackageInfo = conf.packageName + '.domain'
        gp.limitPackageInfo = conf.packageName + '.block'

        writeCodeToFile(file.getPath(), 'domain', domainDirName, '', dbConf.name, conf.tableName, gp)
        writeCodeToFile(file.getPath(), 'domain-meta', mateDirName, 'Mate', dbConf.name, conf.tableName, gp)
        writeCodeToFile(file.getPath(), 'dao', daoDirName, 'Dao', dbConf.name, conf.tableName, gp)
    }

    private void writeCodeToFile(String baseDir, String ftlName, String dirName, String fileNameSuffix, String dbName, String tableName, GenerateParams gp) {
        Map map = this.generateCodeMap(ftlName, dbName, tableName, gp)
        File tmpFile = FileUtil.createTempFile()
        tmpFile.write(map.code)
        String domainPath = FileNameUtil.concat(baseDir, dirName)
        String domainFileName = map.param.classInfo.name + fileNameSuffix + '.java'
        String fullDomainFileName = FileNameUtil.concat(domainPath, domainFileName)
        FileUtil.copy(tmpFile, new File(fullDomainFileName))
        FileUtil.delete(tmpFile)
    }
}