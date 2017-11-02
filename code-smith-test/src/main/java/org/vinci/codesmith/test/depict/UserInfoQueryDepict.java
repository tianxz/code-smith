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
package org.vinci.codesmith.test.depict;

import org.vinci.codesmith.test.domain.meta.UserInfoMeta;
import org.vinci.commons.orm.mybatis.scurd.QueryDepict;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  查询配置
 * Created by vinci on 2017-11-02 17:03:23.
 */
public class UserInfoQueryDepict extends HashMap<String, QueryDepict> {

    public UserInfoQueryDepict() {
        this.put(UserInfoMeta.ID_FIELD_NAME, new QueryDepict("ID", "id"));
        this.put(UserInfoMeta.FIRST_NAME_FIELD_NAME, new QueryDepict("FIRST_NAME", "firstName"));
        this.put(UserInfoMeta.LAST_NAME_FIELD_NAME, new QueryDepict("LAST_NAME", "lastName"));
        this.put(UserInfoMeta.LOGIN_NAME_FIELD_NAME, new QueryDepict("LOGIN_NAME", "loginName"));
        this.put(UserInfoMeta.LOGIN_PASSWORD_FIELD_NAME, new QueryDepict("LOGIN_PASSWORD", "loginPassword"));
        this.put(UserInfoMeta.GENDER_FIELD_NAME, new QueryDepict("GENDER", "gender"));
        this.put(UserInfoMeta.EMAIL_FIELD_NAME, new QueryDepict("EMAIL", "email"));
        this.put(UserInfoMeta.NATIONAL_IDENTIFIER_FIELD_NAME, new QueryDepict("NATIONAL_IDENTIFIER", "nationalIdentifier"));
        this.put(UserInfoMeta.CELL_PHONE_FIELD_NAME, new QueryDepict("CELL_PHONE", "cellPhone"));
        this.put(UserInfoMeta.PEOPLE_TYPE_FIELD_NAME, new QueryDepict("PEOPLE_TYPE", "peopleType"));
        this.put(UserInfoMeta.LAST_LOGIN_TIME_FIELD_NAME, new QueryDepict("LAST_LOGIN_TIME", "lastLoginTime"));
        this.put(UserInfoMeta.LAST_LOGIN_IP_FIELD_NAME, new QueryDepict("LAST_LOGIN_IP", "lastLoginIp"));
    }

    /**
     * 转换 QueryDepict map 为 list
     */
    public List<QueryDepict> toList() {
        List<QueryDepict> lst = new ArrayList<>();
        for (String key : this.keySet()) {
            lst.add(this.get(key));
        }
        return lst;
    }

    /**
     * 重置所有 QueryDepict
     */
    public void resetAll() {
        for (String key : this.keySet()) {
            this.get(key).reset();
        }
    }

    public QueryDepict getQueryDepictForId() {
        return this.get(UserInfoMeta.ID_FIELD_NAME);
    }

    /**
     * 获取查询 [姓] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForFirstName() {
        return this.get(UserInfoMeta.FIRST_NAME_FIELD_NAME);
    }

    /**
     * 获取查询 [名] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForLastName() {
        return this.get(UserInfoMeta.LAST_NAME_FIELD_NAME);
    }

    /**
     * 获取查询 [登录账号] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForLoginName() {
        return this.get(UserInfoMeta.LOGIN_NAME_FIELD_NAME);
    }

    /**
     * 获取查询 [登录密码] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForLoginPassword() {
        return this.get(UserInfoMeta.LOGIN_PASSWORD_FIELD_NAME);
    }

    /**
     * 获取查询 [性别] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForGender() {
        return this.get(UserInfoMeta.GENDER_FIELD_NAME);
    }

    /**
     * 获取查询 [邮箱] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForEmail() {
        return this.get(UserInfoMeta.EMAIL_FIELD_NAME);
    }

    /**
     * 获取查询 [身份证号] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForNationalIdentifier() {
        return this.get(UserInfoMeta.NATIONAL_IDENTIFIER_FIELD_NAME);
    }

    /**
     * 获取查询 [手机] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForCellPhone() {
        return this.get(UserInfoMeta.CELL_PHONE_FIELD_NAME);
    }

    /**
     * 获取查询 [用户状态] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForPeopleType() {
        return this.get(UserInfoMeta.PEOPLE_TYPE_FIELD_NAME);
    }

    /**
     * 获取查询 [最后登录时间] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForLastLoginTime() {
        return this.get(UserInfoMeta.LAST_LOGIN_TIME_FIELD_NAME);
    }

    /**
     * 获取查询 [最后登录IP] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForLastLoginIp() {
        return this.get(UserInfoMeta.LAST_LOGIN_IP_FIELD_NAME);
    }

}