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

/**
 *  查询配置
 * Created by vinci on 2017-10-25 17:36:59.
 */
public class FullTableQueryMap extends HashMap<String, SqlQuery> {

    public FullTableQueryMap() {
        this.put(FullTableMeta.TABLE_CATALOG_FIELD_NAME, new SqlQuery("TABLE_CATALOG", "tableCatalog"));
        this.put(FullTableMeta.TABLE_SCHEMA_FIELD_NAME, new SqlQuery("TABLE_SCHEMA", "tableSchema"));
        this.put(FullTableMeta.TABLE_NAME_FIELD_NAME, new SqlQuery("TABLE_NAME", "tableName"));
        this.put(FullTableMeta.TABLE_TYPE_FIELD_NAME, new SqlQuery("TABLE_TYPE", "tableType"));
        this.put(FullTableMeta.ENGINE_FIELD_NAME, new SqlQuery("ENGINE", "engine"));
        this.put(FullTableMeta.VERSION_FIELD_NAME, new SqlQuery("VERSION", "version"));
        this.put(FullTableMeta.ROW_FORMAT_FIELD_NAME, new SqlQuery("ROW_FORMAT", "rowFormat"));
        this.put(FullTableMeta.TABLE_ROWS_FIELD_NAME, new SqlQuery("TABLE_ROWS", "tableRows"));
        this.put(FullTableMeta.AVG_ROW_LENGTH_FIELD_NAME, new SqlQuery("AVG_ROW_LENGTH", "avgRowLength"));
        this.put(FullTableMeta.DATA_LENGTH_FIELD_NAME, new SqlQuery("DATA_LENGTH", "dataLength"));
        this.put(FullTableMeta.MAX_DATA_LENGTH_FIELD_NAME, new SqlQuery("MAX_DATA_LENGTH", "maxDataLength"));
        this.put(FullTableMeta.INDEX_LENGTH_FIELD_NAME, new SqlQuery("INDEX_LENGTH", "indexLength"));
        this.put(FullTableMeta.DATA_FREE_FIELD_NAME, new SqlQuery("DATA_FREE", "dataFree"));
        this.put(FullTableMeta.AUTO_INCREMENT_FIELD_NAME, new SqlQuery("AUTO_INCREMENT", "autoIncrement"));
        this.put(FullTableMeta.CREATE_TIME_FIELD_NAME, new SqlQuery("CREATE_TIME", "createTime"));
        this.put(FullTableMeta.UPDATE_TIME_FIELD_NAME, new SqlQuery("UPDATE_TIME", "updateTime"));
        this.put(FullTableMeta.CHECK_TIME_FIELD_NAME, new SqlQuery("CHECK_TIME", "checkTime"));
        this.put(FullTableMeta.TABLE_COLLATION_FIELD_NAME, new SqlQuery("TABLE_COLLATION", "tableCollation"));
        this.put(FullTableMeta.CHECKSUM_FIELD_NAME, new SqlQuery("CHECKSUM", "checksum"));
        this.put(FullTableMeta.CREATE_OPTIONS_FIELD_NAME, new SqlQuery("CREATE_OPTIONS", "createOptions"));
        this.put(FullTableMeta.TABLE_COMMENT_FIELD_NAME, new SqlQuery("TABLE_COMMENT", "tableComment"));
    }

	/**
     * 转换 SqlQuery map 为 list
     */
    public List<SqlQuery> toList() {
        List<SqlQuery> lst = new ArrayList<>();
        for (String key : this.keySet()) {
            lst.add(this.get(key));
        }
        return lst;
    }

    /**
     * 重置所有 SqlQuery
     */
    public void resetAll() {
        for (String key : this.keySet()) {
            this.get(key).reset();
        }
    }

    public SqlQuery getSqlQueryForTableCatalog() {
        return this.get(FullTableMeta.TABLE_CATALOG_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableSchema() {
        return this.get(FullTableMeta.TABLE_SCHEMA_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableName() {
        return this.get(FullTableMeta.TABLE_NAME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableType() {
        return this.get(FullTableMeta.TABLE_TYPE_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForEngine() {
        return this.get(FullTableMeta.ENGINE_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForVersion() {
        return this.get(FullTableMeta.VERSION_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForRowFormat() {
        return this.get(FullTableMeta.ROW_FORMAT_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableRows() {
        return this.get(FullTableMeta.TABLE_ROWS_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForAvgRowLength() {
        return this.get(FullTableMeta.AVG_ROW_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForDataLength() {
        return this.get(FullTableMeta.DATA_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForMaxDataLength() {
        return this.get(FullTableMeta.MAX_DATA_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForIndexLength() {
        return this.get(FullTableMeta.INDEX_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForDataFree() {
        return this.get(FullTableMeta.DATA_FREE_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForAutoIncrement() {
        return this.get(FullTableMeta.AUTO_INCREMENT_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForCreateTime() {
        return this.get(FullTableMeta.CREATE_TIME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForUpdateTime() {
        return this.get(FullTableMeta.UPDATE_TIME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForCheckTime() {
        return this.get(FullTableMeta.CHECK_TIME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableCollation() {
        return this.get(FullTableMeta.TABLE_COLLATION_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForChecksum() {
        return this.get(FullTableMeta.CHECKSUM_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForCreateOptions() {
        return this.get(FullTableMeta.CREATE_OPTIONS_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableComment() {
        return this.get(FullTableMeta.TABLE_COMMENT_FIELD_NAME);
    }

}
