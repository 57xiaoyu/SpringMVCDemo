package com.cch.hello.dao;

import com.cch.hello.bean.UserInfo;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Fstar on 2017/1/24.
 */
public class UserDao extends JdbcDaoSupport {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

   /* // 此方法把USEMBO表对应的字段查询出来依次放入userPO中
    public Collection<UserInfo> doquery() {
        String sql = "SELECT T.USERID,T.USERNAME,T.USERAGE FROM USERMBO T";
        return super.getJdbcTemplate().query(sql, new RowMapper() {

            public Object mapRow(ResultSet rs, int num) throws SQLException {
                UserPO user = new UserPO();
                user.setUserId(rs.getInt("USERID"));
                user.setUserName(rs.getString("USERNAME"));
                user.setUserAge(rs.getInt("USERAGE"));
                return user;
            }
        });
    }*/

    public UserInfo findUser(String user_id) {
        String sql = "SELECT * FROM user WHERE user_id=?;";
        final UserInfo user = new UserInfo();
        super.getJdbcTemplate().query(sql,new Object[]{user_id},new RowCallbackHandler(){
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.user_id=rs.getString("user_id");
                user.user_name=rs.getString("user_name");
                user.user_avatar=rs.getString("user_avatar");
                user.user_pwd=rs.getString("user_pwd");
            }
        });

        return user;
    }
}
