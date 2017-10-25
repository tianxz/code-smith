package org.vinci.codesmith.gen.database.service

import org.vinci.codesmith.gen.database.domain.DataBaseConf
import org.vinci.codesmith.gen.database.domain.OneKeyConf
import org.vinci.codesmith.template.engine.TemplateEngine
import org.vinci.codesmith.template.info.AuthorInfo
import org.vinci.codesmith.template.info.DateInfo
import org.vinci.codesmith.template.info.GenerateParams
import org.vinci.codesmith.template.info.ImportList
import org.vinci.codesmith.template.info.PackageInfo
import org.vinci.codesmith.utils.DbMeta2TemplateInfoUtil
import org.vinci.codesmith.utils.WordUtil
import org.vinci.codesmith.utils.UserDataSourceUtil
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
    TableService processTable
    @Autowired
    DbMeta2TemplateInfoUtil dbMeta2TemplateInfoUtil
    @Autowired
    TemplateEngine templateEngine
    @Autowired
    UserDataSourceUtil httpSession

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
        def packageInfo = new PackageInfo(rootName: generateParams.packageInfo)

        def param = [
                "generateParams": generateParams,
                "packageInfo"   : packageInfo,
                "classInfo"     : classInfo,
                "authorInfo"    : authorInfo,
                "dateInfo"      : dateInfo,
                "imports"       : imports,
                "WordUtil"      : WordUtil.class
        ]
        String result = templateEngine.process(param, vmName)

        return [param: param, code: result]
    }

    void oneKeyGenerate(OneKeyConf conf) {
        //创建文件夹 usr/src/com/icss/
        def packageDir = "src/" + conf.packageName.replace(".", "/")
        def file = new File(FileNameUtil.concat(conf.dirPath, packageDir))
        if (!file.exists()) {
            file.mkdirs()
        }

        String domainDirName = 'domain'
        String daoDirName = 'dao'
        String mateDirName = 'domain/meta'
        String mybatisHelpDirName = 'domain/curd'
        String controllerDirName = 'controller'
        DataBaseConf dbConf = httpSession.getDataBaseConf()

        writeCodeToFile(file.getPath(), 'domain', domainDirName, '', dbConf.name, conf.tableName, gp(conf.packageName, "domain"))
        writeCodeToFile(file.getPath(), 'domain-meta', mateDirName, 'Mate', dbConf.name, conf.tableName, gp(conf.packageName, "domain.meta"))
        writeCodeToFile(file.getPath(), 'dao', daoDirName, 'Dao', dbConf.name, conf.tableName, gp(conf.packageName, "dao"))
        writeCodeToFile(file.getPath(), 'domain-update', mybatisHelpDirName, 'UpdateMap', dbConf.name, conf.tableName, gp(conf.packageName, "domain.curd"))
        writeCodeToFile(file.getPath(), 'domain-query', mybatisHelpDirName, 'QueryMap', dbConf.name, conf.tableName, gp(conf.packageName, "domain.curd"))
    }

    private GenerateParams gp(String packageName, String domain) {
        GenerateParams gp = new GenerateParams()
        gp.packageInfo = packageName + "." + domain
        gp.daoPackageInfo = packageName + '.dao'
        gp.domainPackageInfo = packageName + '.domain'
        gp.limitPackageInfo = packageName + '.block'
        return gp
    }

    private void writeCodeToFile(String baseDir, String ftlName, String domainDirName, String fileNameSuffix, String dbName, String tableName, GenerateParams gp) {
        //生成代码
        Map map = this.generateCodeMap(ftlName, dbName, tableName, gp)

        //创建临时文件并写入
        File tmpFile = FileUtil.createTempFile()
        try {
            tmpFile.write(map.code)

            //构造代码保存的路径
            String domainPath = FileNameUtil.concat(baseDir, domainDirName)
            String domainFileName = map.param.classInfo.name + fileNameSuffix + '.java'
            String fullDomainFileName = FileNameUtil.concat(domainPath, domainFileName)

            //复制临时文件为代码文件
            FileUtil.copy(tmpFile, new File(fullDomainFileName))
        } finally {
            FileUtil.delete(tmpFile)
        }
    }
}