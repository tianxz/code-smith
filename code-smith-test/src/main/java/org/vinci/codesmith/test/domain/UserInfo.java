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
package org.vinci.codesmith.test.domain;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jodd.datetime.JDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.vinci.commons.core.serializer.jackson.JDateTimeDeserializer;
import org.vinci.commons.core.serializer.jackson.JDateTimeSerializer;

/**
 * 
 * Created by vinci on 2017-11-03 14:36:05.
 */
public class UserInfo {
    
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;

    //姓
    private String firstName;

    //名
    private String lastName;

    //登录账号
    private String loginName;

    //登录密码
    private String loginPassword;

    //性别
    private boolean gender;

    //邮箱
    private String email;

    //身份证号
    private String nationalIdentifier;

    //手机
    private String cellPhone;

    //用户状态
    private byte peopleType;

    //最后登录时间
    @JsonDeserialize(using = JDateTimeDeserializer.class)
    @JsonSerialize(using = JDateTimeSerializer.class)
    private JDateTime lastLoginTime;

    //最后登录IP
    private String lastLoginIp;

    public long getId() {
        return id;
    }

    public UserInfo setId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 姓
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置 姓
     */
    public UserInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * 获取 名
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置 名
     */
    public UserInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * 获取 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置 登录账号
     */
    public UserInfo setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    /**
     * 获取 登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置 登录密码
     */
    public UserInfo setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        return this;
    }

    /**
     * 获取 性别
     */
    public boolean getGender() {
        return gender;
    }

    /**
     * 设置 性别
     */
    public UserInfo setGender(boolean gender) {
        this.gender = gender;
        return this;
    }

    /**
     * 获取 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 邮箱
     */
    public UserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * 获取 身份证号
     */
    public String getNationalIdentifier() {
        return nationalIdentifier;
    }

    /**
     * 设置 身份证号
     */
    public UserInfo setNationalIdentifier(String nationalIdentifier) {
        this.nationalIdentifier = nationalIdentifier;
        return this;
    }

    /**
     * 获取 手机
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * 设置 手机
     */
    public UserInfo setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        return this;
    }

    /**
     * 获取 用户状态
     */
    public byte getPeopleType() {
        return peopleType;
    }

    /**
     * 设置 用户状态
     */
    public UserInfo setPeopleType(byte peopleType) {
        this.peopleType = peopleType;
        return this;
    }

    /**
     * 获取 最后登录时间
     */
    public JDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置 最后登录时间
     */
    public UserInfo setLastLoginTime(JDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    /**
     * 获取 最后登录IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置 最后登录IP
     */
    public UserInfo setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
        return this;
    }

}