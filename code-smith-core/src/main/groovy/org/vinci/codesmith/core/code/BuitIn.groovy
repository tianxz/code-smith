package org.vinci.codesmith.core.code

import jodd.io.FileNameUtil
import jodd.io.FileUtil
import org.vinci.codesmith.core.collector.base.dto.EngineType
import org.vinci.codesmith.core.collector.base.dto.FileType
import org.vinci.codesmith.core.collector.base.dto.GenDto
import org.vinci.codesmith.core.collector.database.domain.Table
import org.vinci.codesmith.core.engine.TemplateEngine
import org.vinci.codesmith.core.engine.impl.FreemarkerEngine
import org.vinci.codesmith.core.engine.impl.VelocityEngine
import org.vinci.codesmith.core.exception.VinciException
import org.vinci.codesmith.core.utils.SpringUtil
import org.vinci.codesmith.core.utils.WordUtil

/**
 * Created by XizeTian on 2017/10/25.
 */
abstract class BuitIn {
    private static final ThreadLocal<GenDto> threadLocal = new ThreadLocal<>()

    abstract Map buildContext(GenDto genDto)

    abstract String buildDirName()

    abstract String buildTemplateName()

    abstract String getBeanName()

    void start(GenDto genDto) {
        threadLocal.set(genDto)

        try {
            String fileName = this.buildFileName() + '.' + this.buildFileExtendName()
            String templateName = this.buildTemplateName()
            String baseDirPath = this.buildBaseDirPath()
            String packageDirPath = this.buildPackageDirPath()
            String dirName = this.buildDirName()
            Map context = this.buildContext(genDto)

            TemplateEngine templateEngine
            switch (genDto.engineType) {
                case EngineType.FREEMARKER:
                    templateEngine = SpringUtil.context.getBean(FreemarkerEngine.class)
                    break
                case EngineType.VELOCITY:
                    context.put('WordUtil', WordUtil.class)
                    templateEngine = SpringUtil.context.getBean(VelocityEngine.class)
                    break
            }

            String codeResult = templateEngine.process(context, templateName)

            writerCodeToFile(codeResult, "${baseDirPath}/${packageDirPath}/${dirName}", fileName)
        } finally {
            threadLocal.remove()
        }
    }

    void writerCodeToFile(String code, String fileDir, String fileName) {
        File tmpFile = FileUtil.createTempFile()
        try {
            tmpFile.write(code)

            //构造代码保存的路径
            String filePath = FileNameUtil.concat(fileDir, fileName)

            //复制临时文件为代码文件
            FileUtil.copy(tmpFile, new File(filePath))
        } finally {
            FileUtil.delete(tmpFile)
        }
    }

    String buildPackageDirPath() {
        GenDto genDto = this.getLocalGenDto()
        return genDto.ownerConf.packageName.replace('.', '/')
    }

    String buildBaseDirPath() {
        GenDto genDto = this.getLocalGenDto()
        return genDto.ownerConf.dirPath.replace('.', '/')
    }

    /**
     * 生成文件名称
     * @param genDto
     * @return
     */
    String buildFileName() {
        GenDto genDto = this.getLocalGenDto()
        String fileName
        String tableAliasName
        if (genDto.dataSource instanceof Table) {
            Table table = (Table) genDto.dataSource
            tableAliasName = getRealName(table.tableName)
        } else {
            throw new VinciException("无法识别采集对象的类型")
        }

        switch (genDto.fileType) {
            case FileType.JAVA:
                fileName = WordUtil.of(tableAliasName).toLower().UnderlineField2HumpField().firstToUp().out()
                break
            case FileType.XML:
                fileName = WordUtil.of(tableAliasName).toLower().UnderlineField2StrikeField().out()
                break
            default:
                throw new VinciException("请输入正确的文件类型, 参考: java, xml")
                break
        }
        return fileName
    }

    /**
     * 生成类名
     * @param genDto
     * @return
     */
    String buildClassName() {
        GenDto genDto = this.getLocalGenDto()
        String className
        if (genDto.dataSource instanceof Table) {
            Table table = (Table) genDto.dataSource
            String tableAliasName = getRealName(table.tableName)
            className = WordUtil.of(tableAliasName).toLower().UnderlineField2HumpField().firstToUp().out()
        } else {
            throw new VinciException("无法识别采集对象的类型")
        }
        return className
    }

    /**
     * 生产文件扩展名
     * @param genDto
     * @return
     */
    String buildFileExtendName() {
        GenDto genDto = this.getLocalGenDto()
        return genDto.fileType.getValue()
    }

    /**
     * 生成 package 信息
     * @param genDto
     * @return
     */
    String buildPackageName() {
        GenDto genDto = this.getLocalGenDto()
        if (!genDto.ownerConf.packageName) throw new VinciException("尚未配置 package 信息")
        return genDto.ownerConf.packageName + "." + buildDirName()
    }

    /**
     * 用户输入的 package 信息
     * @return
     */
    String buildBasePackageName() {
        GenDto genDto = this.getLocalGenDto()
        return genDto.ownerConf.packageName
    }

    private GenDto getLocalGenDto() {
        return threadLocal.get()
    }

    private String getRealName(String tableName) {
        GenDto genDto = this.getLocalGenDto()
        return genDto.ownerConf.aliasNameMap.containsKey(tableName) ? genDto.ownerConf.aliasNameMap.get(tableName) : tableName
    }
}