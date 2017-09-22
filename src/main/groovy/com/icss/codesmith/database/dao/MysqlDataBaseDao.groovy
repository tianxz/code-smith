package com.icss.codesmith.database.dao

import com.icss.codesmith.database.meta.Column
import com.icss.codesmith.database.meta.Table
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

/**
 * Created by XizeTian on 2016/12/16.
 */
@Mapper
interface MysqlDataBaseDao {
    /**
     * 获取指定数据库的所有表
     * @param arg0
     * @return
     */
    @Select("select * from tables where table_schema = #{arg0}")
    List<Table> getAllTable(String arg0);

    /**
     * 获取指定表
     * @param arg0
     * @param age1
     * @return
     */
    @Select("select * from tables where table_schema = #{arg0} and table_name = #{arg1}")
    Table getTable(String arg0, String age1);

    /**
     * 获取指定表的所有列
     * @param arg0
     * @param arg1
     * @return
     */
    @Select("select * from columns where table_schema = #{arg0} and table_name = #{arg1}")
    List<Column> getColumnByTable(String arg0, String arg1);
}