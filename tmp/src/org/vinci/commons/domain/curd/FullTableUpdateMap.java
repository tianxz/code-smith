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
package org.vinci.commons.domain.curd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  更新配置
 * Created by vinci on 2017-10-25 17:36:59.
 */
public class FullTableUpdateMap extends HashMap<String, SqlUpdate> {

    public FullTableUpdateMap() {
        this.put(FullTableMeta.TABLE_CATALOG_FIELD_NAME, new SqlUpdate("tableCatalog", "TABLE_CATALOG"));
        this.put(FullTableMeta.TABLE_SCHEMA_FIELD_NAME, new SqlUpdate("tableSchema", "TABLE_SCHEMA"));
        this.put(FullTableMeta.TABLE_NAME_FIELD_NAME, new SqlUpdate("tableName", "TABLE_NAME"));
        this.put(FullTableMeta.TABLE_TYPE_FIELD_NAME, new SqlUpdate("tableType", "TABLE_TYPE"));
        this.put(FullTableMeta.ENGINE_FIELD_NAME, new SqlUpdate("engine", "ENGINE"));
        this.put(FullTableMeta.VERSION_FIELD_NAME, new SqlUpdate("version", "VERSION"));
        this.put(FullTableMeta.ROW_FORMAT_FIELD_NAME, new SqlUpdate("rowFormat", "ROW_FORMAT"));
        this.put(FullTableMeta.TABLE_ROWS_FIELD_NAME, new SqlUpdate("tableRows", "TABLE_ROWS"));
        this.put(FullTableMeta.AVG_ROW_LENGTH_FIELD_NAME, new SqlUpdate("avgRowLength", "AVG_ROW_LENGTH"));
        this.put(FullTableMeta.DATA_LENGTH_FIELD_NAME, new SqlUpdate("dataLength", "DATA_LENGTH"));
        this.put(FullTableMeta.MAX_DATA_LENGTH_FIELD_NAME, new SqlUpdate("maxDataLength", "MAX_DATA_LENGTH"));
        this.put(FullTableMeta.INDEX_LENGTH_FIELD_NAME, new SqlUpdate("indexLength", "INDEX_LENGTH"));
        this.put(FullTableMeta.DATA_FREE_FIELD_NAME, new SqlUpdate("dataFree", "DATA_FREE"));
        this.put(FullTableMeta.AUTO_INCREMENT_FIELD_NAME, new SqlUpdate("autoIncrement", "AUTO_INCREMENT"));
        this.put(FullTableMeta.CREATE_TIME_FIELD_NAME, new SqlUpdate("createTime", "CREATE_TIME"));
        this.put(FullTableMeta.UPDATE_TIME_FIELD_NAME, new SqlUpdate("updateTime", "UPDATE_TIME"));
        this.put(FullTableMeta.CHECK_TIME_FIELD_NAME, new SqlUpdate("checkTime", "CHECK_TIME"));
        this.put(FullTableMeta.TABLE_COLLATION_FIELD_NAME, new SqlUpdate("tableCollation", "TABLE_COLLATION"));
        this.put(FullTableMeta.CHECKSUM_FIELD_NAME, new SqlUpdate("checksum", "CHECKSUM"));
        this.put(FullTableMeta.CREATE_OPTIONS_FIELD_NAME, new SqlUpdate("createOptions", "CREATE_OPTIONS"));
        this.put(FullTableMeta.TABLE_COMMENT_FIELD_NAME, new SqlUpdate("tableComment", "TABLE_COMMENT"));
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
        return this.get(FullTableMeta.TABLE_CATALOG_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableSchema() {
        return this.get(FullTableMeta.TABLE_SCHEMA_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableName() {
        return this.get(FullTableMeta.TABLE_NAME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableType() {
        return this.get(FullTableMeta.TABLE_TYPE_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForEngine() {
        return this.get(FullTableMeta.ENGINE_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForVersion() {
        return this.get(FullTableMeta.VERSION_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForRowFormat() {
        return this.get(FullTableMeta.ROW_FORMAT_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableRows() {
        return this.get(FullTableMeta.TABLE_ROWS_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForAvgRowLength() {
        return this.get(FullTableMeta.AVG_ROW_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForDataLength() {
        return this.get(FullTableMeta.DATA_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForMaxDataLength() {
        return this.get(FullTableMeta.MAX_DATA_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForIndexLength() {
        return this.get(FullTableMeta.INDEX_LENGTH_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForDataFree() {
        return this.get(FullTableMeta.DATA_FREE_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForAutoIncrement() {
        return this.get(FullTableMeta.AUTO_INCREMENT_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForCreateTime() {
        return this.get(FullTableMeta.CREATE_TIME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForUpdateTime() {
        return this.get(FullTableMeta.UPDATE_TIME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForCheckTime() {
        return this.get(FullTableMeta.CHECK_TIME_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableCollation() {
        return this.get(FullTableMeta.TABLE_COLLATION_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForChecksum() {
        return this.get(FullTableMeta.CHECKSUM_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForCreateOptions() {
        return this.get(FullTableMeta.CREATE_OPTIONS_FIELD_NAME);
    }

    public SqlUpdate getSqlUpdateForTableComment() {
        return this.get(FullTableMeta.TABLE_COMMENT_FIELD_NAME);
    }

}
