package org.vinci.codesmith.test;

import jodd.datetime.JDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.vinci.codesmith.test.dao.UserInfoDao;
import org.vinci.codesmith.test.depict.UserInfoQueryDepict;
import org.vinci.codesmith.test.depict.UserInfoUpdateDepict;
import org.vinci.codesmith.test.domain.UserInfo;
import org.vinci.commons.core.datetime.JDate;
import org.vinci.commons.database.JdbcOperator;

import java.util.List;

/**
 * Created by XizeTian on 2017/11/3.
 */

public class TestDao extends DataBaseTest {
    private final static long ID = 6308947494508171264L;

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
        int result = userInfoDao.deleteUserInfo(ID);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testUpdate() {
        List updateDepicts = new UserInfoUpdateDepict()
                .getUpdateDepictForLoginName().setValue("vinci").include().getOwnerDepictMap(UserInfoUpdateDepict.class)
                .getUpdateDepictForLoginPassword().setValue("123456").include().getOwnerDepictMap(UserInfoUpdateDepict.class)
                .toList();

        int result = userInfoDao.updateUserInfo(ID, updateDepicts);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testQuery() {
        List queryDepicts = new UserInfoQueryDepict()
                .getQueryDepictForLoginName().setOperator(JdbcOperator.LIKE).setValue("maintk").include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForLoginPassword().setOperator(JdbcOperator.EQ).setValue(null).include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForLastName().setOperator(JdbcOperator.IN).setValue("Xize").include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForPeopleType().setOperator(JdbcOperator.AND).setValue(4).include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForFirstName().setOperator(JdbcOperator.NEQ).setValue("mt").include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .getQueryDepictForLastLoginTime().setOperator(JdbcOperator.BETWEEN).setMultiValue(new JDate("2017-11-04 00:00:00"), new JDate("2017-11-05 00:00:00")).include().getOwnerDepictMap(UserInfoQueryDepict.class)
                .toList();

        List result = userInfoDao.query(queryDepicts, null);

        Assert.assertEquals(1, result.size());
    }
}