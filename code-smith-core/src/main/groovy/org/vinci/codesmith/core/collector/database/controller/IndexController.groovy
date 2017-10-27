package org.vinci.codesmith.core.collector.database.controller

import org.vinci.codesmith.core.collector.database.domain.DataBaseConf
import org.vinci.codesmith.core.collector.database.domain.Column
import org.vinci.codesmith.core.collector.database.domain.Table
import org.vinci.codesmith.core.collector.database.service.TableService
import org.vinci.codesmith.core.utils.UserDataSourceUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpSession

/**
 * Created by XizeTian on 2016/12/19.
 */
@Controller
@RequestMapping("/database")
class IndexController {
    @Autowired
    @Qualifier("sysProp")
    Properties         sysPro
    @Autowired
    TableService       processTable
    @Autowired
    UserDataSourceUtil userDbSourceUtil
    @Autowired
    HttpSession        httpSession

    /**
     * 获取所有表, 表中包含列
     * @return
     */
    @RequestMapping(value = "/table-with-column", method = RequestMethod.GET)
    @ResponseBody
    List<Table> getTableWithColumn() {
        def tables = processTable.getTabColumn(userDbSourceUtil.defaultDbName)
        return tables
    }

    /**
     * 获取指定数据库的所有表, 表中不包含列
     * @return
     */
    @RequestMapping(value = "/table", method = RequestMethod.GET)
    @ResponseBody
    List<Table> getTables() {
        def tables = processTable.getTabs(userDbSourceUtil.defaultDbName)
        return tables
    }

    /**
     * 获取列 by 表
     * @param tableName
     * @return
     */
    @RequestMapping(value = "/column/{tableName}", method = RequestMethod.GET)
    @ResponseBody
    List<Column> getColumn(@PathVariable String tableName) {
        def cols = processTable.getColumns(userDbSourceUtil.defaultDbName, tableName)
        return cols
    }

    /**
     * 配置数据源
     * @param dbConf
     * @return
     */
    @RequestMapping(value = "/data-source-conf", method = RequestMethod.PUT)
    @ResponseBody
    void dataSourceConf(@RequestBody DataBaseConf dbConf) {
        userDbSourceUtil.dataSource = userDbSourceUtil.buildDataSource(dbConf)
        userDbSourceUtil.dataBaseConf = dbConf

        httpSession.setAttribute('USER:TABLE:MAPPING', dbConf.tableMapping)
    }
}