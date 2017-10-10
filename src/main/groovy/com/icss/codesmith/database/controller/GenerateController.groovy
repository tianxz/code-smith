package com.icss.codesmith.database.controller

import com.icss.codesmith.database.domain.DataBaseConf
import com.icss.codesmith.database.service.GenerateTarget
import com.icss.codesmith.template.info.GenerateParams
import com.icss.codesmith.utils.UserDataSourceUtil
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
    GenerateTarget generateTarget
    @Autowired
    UserDataSourceUtil httpSession

    @RequestMapping(value = "/domain/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domain(@PathVariable String tableName,
                  @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain("domain", dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-meta/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainMeta(@PathVariable String tableName,
                      @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain('domain-meta', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-sql-update/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainSqlUpdate(@PathVariable String tableName,
                           @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain('domain-update', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-sql-query/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainSqlQuery(@PathVariable String tableName,
                          @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain('domain-query', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/mapper/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String mapper(@PathVariable String tableName,
                  @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain('mapper', dbConf.name, tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/dao/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String dao(@PathVariable String tableName,
               @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain('dao', dbConf.name, tableName, generateParams)
        return result
    }
}