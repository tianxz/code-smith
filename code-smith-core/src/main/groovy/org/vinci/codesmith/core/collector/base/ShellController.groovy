package org.vinci.codesmith.core.collector.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.vinci.codesmith.core.code.BuitIn
import org.vinci.codesmith.core.code.BuitInFactory
import org.vinci.codesmith.core.collector.base.dto.EngineType
import org.vinci.codesmith.core.collector.base.dto.FileType
import org.vinci.codesmith.core.collector.base.dto.GenDto
import org.vinci.codesmith.core.collector.base.dto.OneKeyConf
import org.vinci.codesmith.core.collector.database.domain.Table
import org.vinci.codesmith.core.collector.database.service.TableService
import org.vinci.codesmith.core.exception.VinciException
import org.vinci.codesmith.core.plugin.scurd.BuitInForDomain
import org.vinci.codesmith.core.utils.UserDataSourceUtil

/**
 * Created by XizeTian on 2017/10/27.
 */
@Controller
@RequestMapping("/shell")
class ShellController {
    @Autowired
    TableService       tableService
    @Autowired
    UserDataSourceUtil udsUtil
    @Autowired
    BuitInFactory      buitInFactory

    @PostMapping("/one-key")
    @ResponseBody
    void databaseOneKeyGen(@RequestBody OneKeyConf oneKeyConf) {
        if (!oneKeyConf.packageName || !oneKeyConf.dirPath || !oneKeyConf.tableName) {
            throw new VinciException("请输入生成路径,包名(xx.xx or xx),表名")
        }

        if (!oneKeyConf.fileType) {
            oneKeyConf.fileType = FileType.JAVA
        }
        if (!oneKeyConf.engineType) {
            oneKeyConf.engineType = EngineType.FREEMARKER
        }

        for (GenDto genDto : oneKeyConf.genDtoList) {
            Table table = tableService.getTable(udsUtil.defaultDbName, oneKeyConf.tableName)

            if (!genDto.fileType) {
                genDto.fileType = oneKeyConf.fileType
            }
            if (!genDto.engineType) {
                genDto.engineType = oneKeyConf.engineType
            }

            genDto.ownerConf = oneKeyConf
            genDto.dataSource = table

            BuitIn buitIn = buitInFactory.getBI(genDto.codeType)
            buitIn.start(genDto)
        }
    }
}