package org.vinci.codesmith.core.code

import freemarker.core.BuiltIn
import org.vinci.codesmith.core.collector.base.dto.EngineType
import org.vinci.codesmith.core.collector.base.dto.FileType
import org.vinci.codesmith.core.collector.base.dto.GenDto
import org.vinci.codesmith.core.collector.database.domain.Table
import org.vinci.codesmith.core.engine.TemplateEngine
import org.vinci.codesmith.core.engine.impl.FreemarkerEngine
import org.vinci.codesmith.core.engine.impl.VelocityEngine
import org.vinci.codesmith.core.exception.VinciException
import org.vinci.codesmith.core.utils.WordUtil

/**
 * Created by XizeTian on 2017/10/25.
 */
abstract class BuitIn {
    private static final HashMap             hashMap     = new HashMap()
    private static final ThreadLocal<GenDto> threadLocal = new ThreadLocal<>()

    static {

    }

    static void putBI(String name, BuiltIn bi) {
        hashMap.put(name, bi)
    }

    static void init() {
        final ClassLoader classLoader = BuitIn.class.getClassLoader()

        println ''
    }

    abstract Map buildContext(GenDto genDto)

    abstract String buildDirName()

    abstract buildTemplateName()

    void start(GenDto genDto) {
        threadLocal.set(genDto)

        try {
            String fileName = this.buildFileName()
            String fileExtendName = this.buildFileExtendName()
            String className = this.buildClassName()
            String packageName = this.buildPackageName()
            String rootPackageName = this.buildBasePackageName()
            String templateName = this.buildTemplateName()
            String baseDirPath = this.buildBaseDirPath()
            String packageDirPath = this.buildPackageDirPath()
            String dirName = this.buildDirName()
            Map context = this.buildContext(genDto)

            TemplateEngine templateEngine
            switch (genDto.engineType) {
                case EngineType.FREEMARKER:
                    templateEngine = new FreemarkerEngine()
                    break
                case EngineType.VELOCITY:
                    templateEngine = new VelocityEngine()
                    break
            }

            String codeResult = templateEngine.process(context, templateName)
        } finally {
            threadLocal.remove()
        }
    }

    String buildPackageDirPath() {
        GenDto genDto = this.getGenDto()
        return genDto.ownerConf.packageName.replace('.', '/')
    }

    String buildBaseDirPath() {
        GenDto genDto = this.getGenDto()
        return genDto.ownerConf.dirPath.replace('.', '/')
    }

    /**
     * 生成文件名称
     * @param genDto
     * @return
     */
    String buildFileName() {
        GenDto genDto = this.getGenDto()
        String fileName
        if (genDto.dataSource instanceof Table) {
            Table table = (Table) genDto.dataSource
            String tableAliasName = getRealName(table.tableName)
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
        } else {
            throw new VinciException("无法识别采集对象的类型")
        }
        return fileName + '.' + this.buildFileExtendName()
    }

    /**
     * 生成类名
     * @param genDto
     * @return
     */
    String buildClassName() {
        GenDto genDto = this.getGenDto()
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
        GenDto genDto = this.getGenDto()
        return genDto.fileType ? 'java' : genDto.fileType.getValue()
    }

    /**
     * 生成 package 信息
     * @param genDto
     * @return
     */
    String buildPackageName() {
        GenDto genDto = this.getGenDto()
        if (!genDto.ownerConf.packageName) throw new VinciException("尚未配置 package 信息")
        return genDto.ownerConf.packageName + "." + buildDirName()
    }

    String buildBasePackageName() {
        GenDto genDto = this.getGenDto()
        return genDto.ownerConf.packageName
    }

    private GenDto getGenDto() {
        return threadLocal.get()
    }

    private String getRealName(String tableName) {
        GenDto genDto = this.getGenDto()
        return genDto.ownerConf.aliasNameMap.containsKey(tableName) ? genDto.ownerConf.aliasNameMap.get(tableName) : tableName
    }
}