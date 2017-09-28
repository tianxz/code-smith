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

/**
 * 此代码由代码生成工具生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 *  __/\\\\\\\\\\\__________________/\\\\\\\\\_______________/\\\\\\\\\\\_________________/\\\\\\\\\\\___
 *  _\/////\\\///________________/\\\////////______________/\\\/////////\\\_____________/\\\/////////\\\_
 *  _____\/\\\_________________/\\\/______________________\//\\\______\///_____________\//\\\______\///__
 *  _____\/\\\________________/\\\_________________________\////\\\_____________________\////\\\_________
 *  _____\/\\\_______________\/\\\____________________________\////\\\_____________________\////\\\______
 *  _____\/\\\_______________\//\\\______________________________\////\\\_____________________\////\\\___
 *  _____\/\\\________________\///\\\_____________________/\\\______\//\\\_____________/\\\______\//\\\__
 *  __/\\\\\\\\\\\______________\////\\\\\\\\\___________\///\\\\\\\\\\\/_____________\///\\\\\\\\\\\/___
 *  _\///////////__________________\/////////______________\///////////_________________\///////////_____
 *  此代码由代码生成工具生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 */
@Controller
@RequestMapping( "/generate" )
class GenerateController {
    @Autowired
    GenerateTarget     generateTarget
    @Autowired
    UserDataSourceUtil httpSession

    @RequestMapping( value = "/domain/{tableName}", method = RequestMethod.POST )
    @ResponseBody
    String domain( @PathVariable String tableName,
                   @RequestBody GenerateParams generateParams ) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain( "domain", dbConf.name, tableName, generateParams )
        return result
    }

    @RequestMapping( value = "/domain-meta/{tableName}", method = RequestMethod.POST )
    @ResponseBody
    String domainMeta( @PathVariable String tableName,
                       @RequestBody GenerateParams generateParams ) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain( 'domain-meta', dbConf.name, tableName, generateParams )
        return result
    }

    @RequestMapping( value = "/domain-sql-update/{tableName}", method = RequestMethod.POST )
    @ResponseBody
    String domainSqlUpdate( @PathVariable String tableName,
                            @RequestBody GenerateParams generateParams ) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain( 'domain-update', dbConf.name, tableName, generateParams )
        return result
    }

    @RequestMapping( value = "/domain-sql-query/{tableName}", method = RequestMethod.POST )
    @ResponseBody
    String domainSqlQuery( @PathVariable String tableName,
                           @RequestBody GenerateParams generateParams ) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain( 'domain-query', dbConf.name, tableName, generateParams )
        return result
    }
}