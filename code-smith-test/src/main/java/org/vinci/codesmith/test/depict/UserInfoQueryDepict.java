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
import org.vinci.commons.orm.mybatis.scurd.CurdAbstractDepictMap;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息表 查询配置
 * Created by vinci on 2017-11-04 18:01:08.
 */
public class UserInfoQueryDepict extends CurdAbstractDepictMap<QueryDepict> {

    public UserInfoQueryDepict() {
        this.put(UserInfoMeta.ID_FIELD_NAME, new QueryDepict("id", "ID", this));
        this.put(UserInfoMeta.FIRST_NAME_FIELD_NAME, new QueryDepict("firstName", "FIRST_NAME", this));
        this.put(UserInfoMeta.LAST_NAME_FIELD_NAME, new QueryDepict("lastName", "LAST_NAME", this));
        this.put(UserInfoMeta.LOGIN_NAME_FIELD_NAME, new QueryDepict("loginName", "LOGIN_NAME", this));
        this.put(UserInfoMeta.LOGIN_PASSWORD_FIELD_NAME, new QueryDepict("loginPassword", "LOGIN_PASSWORD", this));
        this.put(UserInfoMeta.GENDER_FIELD_NAME, new QueryDepict("gender", "GENDER", this));
        this.put(UserInfoMeta.EMAIL_FIELD_NAME, new QueryDepict("email", "EMAIL", this));
        this.put(UserInfoMeta.NATIONAL_IDENTIFIER_FIELD_NAME, new QueryDepict("nationalIdentifier", "NATIONAL_IDENTIFIER", this));
        this.put(UserInfoMeta.CELL_PHONE_FIELD_NAME, new QueryDepict("cellPhone", "CELL_PHONE", this));
        this.put(UserInfoMeta.PEOPLE_TYPE_FIELD_NAME, new QueryDepict("peopleType", "PEOPLE_TYPE", this));
        this.put(UserInfoMeta.LAST_LOGIN_TIME_FIELD_NAME, new QueryDepict("lastLoginTime", "LAST_LOGIN_TIME", this));
        this.put(UserInfoMeta.LAST_LOGIN_IP_FIELD_NAME, new QueryDepict("lastLoginIp", "LAST_LOGIN_IP", this));
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

    /**
     * 获取查询 [id] 的 QueryDepict
     */
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
     * 获取查询 [登录名] 的 QueryDepict
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
     * 获取查询 [手机号] 的 QueryDepict
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
     * 获取查询 [最后登录日期] 的 QueryDepict
     */
    public QueryDepict getQueryDepictForLastLoginIp() {
        return this.get(UserInfoMeta.LAST_LOGIN_IP_FIELD_NAME);
    }

}