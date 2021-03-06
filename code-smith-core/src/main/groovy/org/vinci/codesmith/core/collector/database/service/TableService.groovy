package org.vinci.codesmith.core.collector.database.service

import org.vinci.codesmith.core.collector.database.dao.MysqlDataBaseDao
import org.vinci.codesmith.core.collector.database.domain.Table
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.vinci.codesmith.core.collector.database.domain.Column

import javax.servlet.http.HttpSession

/**
 * Created by XizeTian on 2016/12/16.
 */
@Service
class TableService {
    @Autowired
    MysqlDataBaseDao dao
    @Autowired
    HttpSession      httpSession

    /**
     * 获取指定数据库的所有表, 表中包含列
     * @param dbName
     * @return
     */
    List<Table> getTabColumn(String dbName) {
        def tables = getTabs(dbName)
        for (table in tables) {
            def columns = getColumns(dbName, table.tableName)
            table.columns = columns
        }
        return tables
    }

    /**
     * 获取指定数据库的所有表, 表中不包含列
     * @return
     */
    List<Table> getTabs(String dbName) {
        def tables = dao.getAllTable(dbName)
        return tables
    }

    /**
     * 获取指定表
     * @param dbName
     * @param tableName
     * @return
     */
    Table getTable(String dbName, String tableName) {
        def table = dao.getTable(dbName, tableName)
        def columns = getColumns(dbName, table.tableName)
        table.columns = columns
        return table
    }

    /**
     * 获取指定数据库,指定表的所有列
     * @param dbName
     * @param tableNames
     * @return
     */
    List<Column> getColumns(String dbName, String tableName) {
        def columns = dao.getColumnByTable(dbName, tableName)
        return columns
    }
}
