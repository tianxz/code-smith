package org.vinci.codesmith.gen.database.controller

import org.vinci.codesmith.gen.database.domain.DataBaseConf
import org.vinci.codesmith.gen.database.domain.OneKeyConf
import org.vinci.codesmith.gen.database.service.GenerateService
import org.vinci.codesmith.exception.VinciException
import org.vinci.codesmith.template.info.GenerateParams
import org.vinci.codesmith.utils.UserDataSourceUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by XizeTian on 2016/12/19.
 */
@Controller
@RequestMapping("/generate")
class GenerateController {
    @Autowired
    GenerateService    generateTarget
    @Autowired
    UserDataSourceUtil httpSession

    @RequestMapping(value = "/domain/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domain(@PathVariable String tableName,
                  @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateCode("domain", dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-meta/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainMeta(@PathVariable String tableName,
                      @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateCode('domain-meta', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-sql-update/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainSqlUpdate(@PathVariable String tableName,
                           @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateCode('domain-update', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-sql-query/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainSqlQuery(@PathVariable String tableName,
                          @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateCode('domain-query', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/mapper/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String mapper(@PathVariable String tableName,
                  @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateCode('mapper', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/dao/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String dao(@PathVariable String tableName,
               @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateCode('dao', dbConf.name, tableName, generateParams)
        return result
    }

    @PostMapping("/one-key")
    @ResponseBody
    void oneKey(@RequestBody OneKeyConf oneKeyConf) {
        if (!oneKeyConf.packageName || !oneKeyConf.dirPath || !oneKeyConf.tableName) {
            throw new VinciException("请输入生成路径,包名(xx.xx or xx),表名")
        }
        generateTarget.oneKeyGenerate(oneKeyConf)
    }
}