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
import org.vinci.commons.orm.mybatis.scurd.UpdateDepict;
import org.vinci.commons.orm.mybatis.scurd.CurdAbstractDepictMap;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息表 更新配置
 * Created by vinci on 2017-11-06 11:10:12.
 */
public class UserInfoUpdateDepict extends CurdAbstractDepictMap<UpdateDepict> {

    public UserInfoUpdateDepict() {
        this.put(UserInfoMeta.ID_FIELD_NAME, new UpdateDepict(UserInfoMeta.ID_FIELD_NAME, UserInfoMeta.ID_COLUMN_NAME, this));
        this.put(UserInfoMeta.FIRST_NAME_FIELD_NAME, new UpdateDepict(UserInfoMeta.FIRST_NAME_FIELD_NAME, UserInfoMeta.FIRST_NAME_COLUMN_NAME, this));
        this.put(UserInfoMeta.LAST_NAME_FIELD_NAME, new UpdateDepict(UserInfoMeta.LAST_NAME_FIELD_NAME, UserInfoMeta.LAST_NAME_COLUMN_NAME, this));
        this.put(UserInfoMeta.LOGIN_NAME_FIELD_NAME, new UpdateDepict(UserInfoMeta.LOGIN_NAME_FIELD_NAME, UserInfoMeta.LOGIN_NAME_COLUMN_NAME, this));
        this.put(UserInfoMeta.LOGIN_PASSWORD_FIELD_NAME, new UpdateDepict(UserInfoMeta.LOGIN_PASSWORD_FIELD_NAME, UserInfoMeta.LOGIN_PASSWORD_COLUMN_NAME, this));
        this.put(UserInfoMeta.GENDER_FIELD_NAME, new UpdateDepict(UserInfoMeta.GENDER_FIELD_NAME, UserInfoMeta.GENDER_COLUMN_NAME, this));
        this.put(UserInfoMeta.EMAIL_FIELD_NAME, new UpdateDepict(UserInfoMeta.EMAIL_FIELD_NAME, UserInfoMeta.EMAIL_COLUMN_NAME, this));
        this.put(UserInfoMeta.NATIONAL_IDENTIFIER_FIELD_NAME, new UpdateDepict(UserInfoMeta.NATIONAL_IDENTIFIER_FIELD_NAME, UserInfoMeta.NATIONAL_IDENTIFIER_COLUMN_NAME, this));
        this.put(UserInfoMeta.CELL_PHONE_FIELD_NAME, new UpdateDepict(UserInfoMeta.CELL_PHONE_FIELD_NAME, UserInfoMeta.CELL_PHONE_COLUMN_NAME, this));
        this.put(UserInfoMeta.PEOPLE_TYPE_FIELD_NAME, new UpdateDepict(UserInfoMeta.PEOPLE_TYPE_FIELD_NAME, UserInfoMeta.PEOPLE_TYPE_COLUMN_NAME, this));
        this.put(UserInfoMeta.LAST_LOGIN_TIME_FIELD_NAME, new UpdateDepict(UserInfoMeta.LAST_LOGIN_TIME_FIELD_NAME, UserInfoMeta.LAST_LOGIN_TIME_COLUMN_NAME, this));
        this.put(UserInfoMeta.LAST_LOGIN_IP_FIELD_NAME, new UpdateDepict(UserInfoMeta.LAST_LOGIN_IP_FIELD_NAME, UserInfoMeta.LAST_LOGIN_IP_COLUMN_NAME, this));
    }

    /**
     * 获取更新 [id] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForId() {
        return this.get(UserInfoMeta.ID_FIELD_NAME);
    }

    /**
     * 获取更新 [姓] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForFirstName() {
        return this.get(UserInfoMeta.FIRST_NAME_FIELD_NAME);
    }

    /**
     * 获取更新 [名] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForLastName() {
        return this.get(UserInfoMeta.LAST_NAME_FIELD_NAME);
    }

    /**
     * 获取更新 [登录名] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForLoginName() {
        return this.get(UserInfoMeta.LOGIN_NAME_FIELD_NAME);
    }

    /**
     * 获取更新 [登录密码] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForLoginPassword() {
        return this.get(UserInfoMeta.LOGIN_PASSWORD_FIELD_NAME);
    }

    /**
     * 获取更新 [性别] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForGender() {
        return this.get(UserInfoMeta.GENDER_FIELD_NAME);
    }

    /**
     * 获取更新 [邮箱] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForEmail() {
        return this.get(UserInfoMeta.EMAIL_FIELD_NAME);
    }

    /**
     * 获取更新 [身份证号] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForNationalIdentifier() {
        return this.get(UserInfoMeta.NATIONAL_IDENTIFIER_FIELD_NAME);
    }

    /**
     * 获取更新 [手机号] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForCellPhone() {
        return this.get(UserInfoMeta.CELL_PHONE_FIELD_NAME);
    }

    /**
     * 获取更新 [用户状态] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForPeopleType() {
        return this.get(UserInfoMeta.PEOPLE_TYPE_FIELD_NAME);
    }

    /**
     * 获取更新 [最后登录时间] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForLastLoginTime() {
        return this.get(UserInfoMeta.LAST_LOGIN_TIME_FIELD_NAME);
    }

    /**
     * 获取更新 [最后登录日期] 的 UpdateDepict
     */
    public UpdateDepict getUpdateDepictForLastLoginIp() {
        return this.get(UserInfoMeta.LAST_LOGIN_IP_FIELD_NAME);
    }

}
