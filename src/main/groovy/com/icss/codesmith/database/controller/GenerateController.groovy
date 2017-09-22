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
    String domain(@PathVariable String tableName, @RequestBody GenerateParams generateParams) {
        DataBaseConf dbConf = httpSession.getDataBaseConf()
        def result = generateTarget.generateDomain(dbConf.name, tableName, generateParams)
        return result
    }
}