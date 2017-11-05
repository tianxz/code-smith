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

/**
 *  查询配置
 * Created by vinci on 2017-10-27 07:22:40.
 */
public class TrueQueryMap extends HashMap<String, SqlQuery> {

    public TrueQueryMap() {
        this.put(TrueMeta.TABLE_CATALOG_FIELD_NAME, new SqlQuery("TABLE_CATALOG", "tableCatalog"));
        this.put(TrueMeta.TABLE_SCHEMA_FIELD_NAME, new SqlQuery("TABLE_SCHEMA", "tableSchema"));
        this.put(TrueMeta.TABLE_NAME_FIELD_NAME, new SqlQuery("TABLE_NAME", "tableName"));
        this.put(TrueMeta.TABLE_TYPE_FIELD_NAME, new SqlQuery("TABLE_TYPE", "tableType"));
        this.put(TrueMeta.ENGINE_FIELD_NAME, new SqlQuery("ENGINE", "engine"));
        this.put(TrueMeta.VERSION_FIELD_NAME, new SqlQuery("VERSION", "version"));
        this.put(TrueMeta.ROW_FORMAT_FIELD_NAME, new SqlQuery("ROW_FORMAT", "rowFormat"));
        this.put(TrueMeta.TABLE_ROWS_FIELD_NAME, new SqlQuery("TABLE_ROWS", "tableRows"));
        this.put(TrueMeta.AVG_ROW_LENGTH_FIELD_NAME, new SqlQuery("AVG_ROW_LENGTH", "avgRowLength"));
        this.put(TrueMeta.DATA_LENGTH_FIELD_NAME, new SqlQuery("DATA_LENGTH", "dataLength"));
        this.put(TrueMeta.MAX_DATA_LENGTH_FIELD_NAME, new SqlQuery("MAX_DATA_LENGTH", "maxDataLength"));
        this.put(TrueMeta.INDEX_LENGTH_FIELD_NAME, new SqlQuery("INDEX_LENGTH", "indexLength"));
        this.put(TrueMeta.DATA_FREE_FIELD_NAME, new SqlQuery("DATA_FREE", "dataFree"));
        this.put(TrueMeta.AUTO_INCREMENT_FIELD_NAME, new SqlQuery("AUTO_INCREMENT", "autoIncrement"));
        this.put(TrueMeta.CREATE_TIME_FIELD_NAME, new SqlQuery("CREATE_TIME", "createTime"));
        this.put(TrueMeta.UPDATE_TIME_FIELD_NAME, new SqlQuery("UPDATE_TIME", "updateTime"));
        this.put(TrueMeta.CHECK_TIME_FIELD_NAME, new SqlQuery("CHECK_TIME", "checkTime"));
        this.put(TrueMeta.TABLE_COLLATION_FIELD_NAME, new SqlQuery("TABLE_COLLATION", "tableCollation"));
        this.put(TrueMeta.CHECKSUM_FIELD_NAME, new SqlQuery("CHECKSUM", "checksum"));
        this.put(TrueMeta.CREATE_OPTIONS_FIELD_NAME, new SqlQuery("CREATE_OPTIONS", "createOptions"));
        this.put(TrueMeta.TABLE_COMMENT_FIELD_NAME, new SqlQuery("TABLE_COMMENT", "tableComment"));
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
        return this.get(TrueMeta.TABLE_CATALOG_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableSchema() {
        return this.get(TrueMeta.TABLE_SCHEMA_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableName() {
        return this.get(TrueMeta.TABLE_NAME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableType() {
        return this.get(TrueMeta.TABLE_TYPE_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForEngine() {
        return this.get(TrueMeta.ENGINE_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForVersion() {
        return this.get(TrueMeta.VERSION_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForRowFormat() {
        return this.get(TrueMeta.ROW_FORMAT_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableRows() {
        return this.get(TrueMeta.TABLE_ROWS_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForAvgRowLength() {
        return this.get(TrueMeta.AVG_ROW_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForDataLength() {
        return this.get(TrueMeta.DATA_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForMaxDataLength() {
        return this.get(TrueMeta.MAX_DATA_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForIndexLength() {
        return this.get(TrueMeta.INDEX_LENGTH_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForDataFree() {
        return this.get(TrueMeta.DATA_FREE_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForAutoIncrement() {
        return this.get(TrueMeta.AUTO_INCREMENT_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForCreateTime() {
        return this.get(TrueMeta.CREATE_TIME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForUpdateTime() {
        return this.get(TrueMeta.UPDATE_TIME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForCheckTime() {
        return this.get(TrueMeta.CHECK_TIME_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableCollation() {
        return this.get(TrueMeta.TABLE_COLLATION_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForChecksum() {
        return this.get(TrueMeta.CHECKSUM_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForCreateOptions() {
        return this.get(TrueMeta.CREATE_OPTIONS_FIELD_NAME);
    }

    public SqlQuery getSqlQueryForTableComment() {
        return this.get(TrueMeta.TABLE_COMMENT_FIELD_NAME);
    }

}
