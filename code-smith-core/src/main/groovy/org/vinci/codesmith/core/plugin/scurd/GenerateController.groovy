package org.vinci.codesmith.core.plugin.scurd

import org.vinci.codesmith.core.template.info.GenerateParams
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
    GenerateService generateTarget

    @RequestMapping(value = "/domain/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domain(@PathVariable String tableName,
                  @RequestBody GenerateParams generateParams) {
        def result = generateTarget.generateCode("domain", tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-meta/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainMeta(@PathVariable String tableName,
                      @RequestBody GenerateParams generateParams) {
        def result = generateTarget.generateCode('domain-meta', tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-sql-update/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainSqlUpdate(@PathVariable String tableName,
                           @RequestBody GenerateParams generateParams) {
        def result = generateTarget.generateCode('domain-update', tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/domain-sql-query/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String domainSqlQuery(@PathVariable String tableName,
                          @RequestBody GenerateParams generateParams) {
        def result = generateTarget.generateCode('domain-query', tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/mapper/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String mapper(@PathVariable String tableName,
                  @RequestBody GenerateParams generateParams) {
        def result = generateTarget.generateCode('mapper', tableName, generateParams)
        return result
    }

    @RequestMapping(value = "/dao/{tableName}", method = RequestMethod.POST)
    @ResponseBody
    String dao(@PathVariable String tableName,
               @RequestBody GenerateParams generateParams) {
        def result = generateTarget.generateCode('dao', tableName, generateParams)
        return result
    }
}