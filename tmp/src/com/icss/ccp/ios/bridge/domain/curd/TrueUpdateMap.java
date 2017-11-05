/***********************************************************************************
 *  __/\\\\\\\\\\\________/\\\\\\\\\_____/\\\\\\\\\\\_______/\\\\\\\\\\\___        *
 *   _\/////\\\///______/\\\////////____/\\\/////////\\\___/\\\/////////\\\_       *
 *    _____\/\\\_______/\\\/____________\//\\\______\///___\//\\\______\///__      *
 *     _____\/\\\______/\\\_______________\////\\\___________\////\\\_________     *
 *      _____\/\\\_____\/\\\__________________\////\\\___________\////\\\______    *
 *       _____\/\\\_____\//\\\____________________\////\\\___________\////\\\___   *
 *        _____\/\\\______\///\\\___________/\\\______\//\\\___/\\\______\//\\\__  *
 *         __/\\\\\\\\\\\____\////\\\\\\\\\_\///\\\\\\\\\\\/___\///\\\\\\\\\\\/___ *
 ***********************************************************************************
 *  此代码自动生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 *  此代码自动生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 *  此代码自动生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 ***********************************************************************************/
package com.icss.ccp.ios.bridge.domain.curd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  更新配置
 * Created by vinci on 2017-10-27 07:22:40.
 */
public class TrueUpdateMap extends HashMap<String, SqlUpdate> {

    public TrueUpdateMap() {
        this.put(TrueMeta.TABLE_CATALOG_FIELD_NAME, new SqlUpdate("tableCatalog", "TABLE_CATALOG"));
        this.put(TrueMeta.TABLE_SCHEMA_FIELD_NAME, new SqlUpdate("tableSchema", "TABLE_SCHEMA"));
        this.put(TrueMeta.TABLE_NAME_FIELD_NAME, new SqlUpdate("tableName", "TABLE_NAME"));
        this.put(TrueMeta.TABLE_TYPE_FIELD_NAME, new SqlUpdate("tableType", "TABLE_TYPE"));
        this.put(TrueMeta.ENGINE_FIELD_NAME, new SqlUpdate("engine", "ENGINE"));
        this.put(TrueMeta.VERSION_FIELD_NAME, new SqlUpdate("version", "VERSION"));
        this.put(TrueMeta.ROW_FORMAT_FIELD_NAME, new SqlUpdate("rowFormat", "ROW_FORMAT"));
        this.put(TrueMeta.TABLE_ROWS_FIELD_NAME, new SqlUpdate("tableRows", "TABLE_ROWS"));
        this.put(TrueMeta.AVG_ROW_LENGTH_FIELD_NAME, new SqlUpdate("avgRowLength", "AVG_ROW_LENGTH"));
        this.put(TrueMeta.DATA_LENGTH_FIELD_NAME, new SqlUpdate("dataLength", "DATA_LENGTH"));
        this.put(TrueMeta.MAX_DATA_LENGTH_FIELD_NAME, new SqlUpdate("maxDataLength", "MAX_DATA_LENGTH"));
        this.put(TrueMeta.INDEX_LENGTH_FIELD_NAME, new SqlUpdate("indexLength", "INDEX_LENGTH"));
        this.put(TrueMeta.DATA_FREE_FIELD_NAME, new SqlUpdate("dataFree", "DATA_FREE"));
        this.put(TrueMeta.AUTO_INCREMENT_FIELD_NAME, new SqlUpdate("autoIncrement", "AUTO_INCREMENT"));
        this.put(TrueMeta.CREATE_TIME_FIELD_NAME, new SqlUpdate("createTime", "CREATE_TIME"));
        this.put(TrueMeta.UPDATE_TIME_FIELD_NAME, new SqlUpdate("updateTime", "UPDATE_TIME"));
        this.put(TrueMeta.CHECK_TIME_FIELD_NAME, new SqlUpdate("checkTime", "CHECK_TIME"));
        this.put(TrueMeta.TABLE_COLLATION_FIELD_NAME, new SqlUpdate("tableCollation", "TABLE_COLLATION"));
        this.put(TrueMeta.CHECKSUM_FIELD_NAME, new SqlUpdate("checksum", "CHECKSUM"));
        this.put(TrueMeta.CREATE_OPTIONS_FIELD_NAME, new SqlUpdate("createOptions", "CREATE_OPTIONS"));
        this.put(TrueMeta.TABLE_COMMENT_FIELD_NAME, new SqlUpdate("tableComment", "TABLE_COMMENT"));
    }

	/**
     * 转换 SqlUpdate map 为 list
     */
    public List<SqlUpdate> toList() {
        List<SqlUpdate> lst = new ArrayList<>();
        for (String key : this.keySet()) {
            lst.add(this.get(key));
        }
        return lst;
    }
	
    /**
     * 重置所有 SqlUpdate
     */
    public void resetAll() {
        for (String key : this.keySet()) {
            this.get(key).reset();
        }
    }

    public SqlUpdate getSqlUpdateForTableCatalog() {
        return this.get(TrueMeta.TABLE_CATALOG_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableSchema() {
        return this.get(TrueMeta.TABLE_SCHEMA_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableName() {
        return this.get(TrueMeta.TABLE_NAME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableType() {
        return this.get(TrueMeta.TABLE_TYPE_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForEngine() {
        return this.get(TrueMeta.ENGINE_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForVersion() {
        return this.get(TrueMeta.VERSION_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForRowFormat() {
        return this.get(TrueMeta.ROW_FORMAT_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableRows() {
        return this.get(TrueMeta.TABLE_ROWS_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForAvgRowLength() {
        return this.get(TrueMeta.AVG_ROW_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForDataLength() {
        return this.get(TrueMeta.DATA_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForMaxDataLength() {
        return this.get(TrueMeta.MAX_DATA_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForIndexLength() {
        return this.get(TrueMeta.INDEX_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForDataFree() {
        return this.get(TrueMeta.DATA_FREE_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForAutoIncrement() {
        return this.get(TrueMeta.AUTO_INCREMENT_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForCreateTime() {
        return this.get(TrueMeta.CREATE_TIME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForUpdateTime() {
        return this.get(TrueMeta.UPDATE_TIME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForCheckTime() {
        return this.get(TrueMeta.CHECK_TIME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableCollation() {
        return this.get(TrueMeta.TABLE_COLLATION_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForChecksum() {
        return this.get(TrueMeta.CHECKSUM_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForCreateOptions() {
        return this.get(TrueMeta.CREATE_OPTIONS_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableComment() {
        return this.get(TrueMeta.TABLE_COMMENT_FIELD_NAME);
    }

}
