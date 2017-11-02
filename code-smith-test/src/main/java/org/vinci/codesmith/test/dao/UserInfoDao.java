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
package org.vinci.codesmith.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.vinci.codesmith.test.domain.UserInfo;
import org.vinci.commons.database.block.Limit;
import org.vinci.commons.orm.mybatis.scurd.QueryDepict;
import org.vinci.commons.orm.mybatis.scurd.UpdateDepict;

import java.util.List;

@Mapper
public interface UserInfoDao {
    long queryTotal(@Param("queryDepicts") List<QueryDepict> queryDepicts);

    List<UserInfo> queryAll(@Param("limit") Limit limit);

    List<UserInfo> query(@Param("queryDepicts") List<QueryDepict> queryDepicts, @Param("limit") Limit limit);

    UserInfo querySingle(@Param("queryDepicts") List<QueryDepict> queryDepicts);

    UserInfo queryById(long uuid);

    int insertUserInfo(UserInfo UserInfo);

    int updateUserInfo(@Param("uuid") long uuid, @Param("updateDepicts") List<UpdateDepict> updateDepicts);

    int deleteUserInfo(long uuid);
}
