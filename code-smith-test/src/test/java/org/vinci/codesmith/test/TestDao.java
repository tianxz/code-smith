package org.vinci.codesmith.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.vinci.codesmith.test.dao.UserInfoDao;
import org.vinci.codesmith.test.depict.UserInfoQueryDepict;
import org.vinci.codesmith.test.depict.UserInfoUpdateDepict;
import org.vinci.codesmith.test.domain.UserInfo;
import org.vinci.commons.database.JdbcOperator;

import java.util.List;

/**
 * Created by XizeTian on 2017/11/3.
 */

public class TestDao extends DataBaseTest {
    @Autowired
    UserInfoDao userInfoDao;

    @Test
    public void testInsert() {
        UserInfo userInfo = new UserInfo().setId(1).setLoginName("maintk").setLoginPassword("123456");

        int result = userInfoDao.insertUserInfo(userInfo);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = userInfoDao.deleteUserInfo(19870606);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testUpdate() {
        List updateDepicts = new UserInfoUpdateDepict()
                .getUpdateDepictForLoginName().setValue("vinci").include().getOwnerDepictMap(UserInfoUpdateDepict.class)
                .getUpdateDepictForLoginPassword().setValue("123456").include().getOwnerDepictMap(UserInfoUpdateDepict.class)
                .toList();

        int result = userInfoDao.updateUserInfo(19870606, updateDepicts);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testQuery() {
        List queryDepicts = new UserInfoQueryDepict()
                .getQueryDepictForLoginName().setOperator(JdbcOperator.LIKE).setValue("main").include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForLoginName().setOperator(JdbcOperator.IN).setValue("maintk").include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForLoginName().setOperator(JdbcOperator.NEQ).setValue("1").include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForLoginPassword().setOperator(JdbcOperator.EQ).setValue("123456").include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .toList();

        List result = userInfoDao.query(queryDepicts, null);

        Assert.assertEquals(1, result.size());
    }
}
