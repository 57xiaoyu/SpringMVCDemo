package com.cch.hello.dao;

import com.cch.hello.bean.UserInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Fstar on 2017/1/24.
 */
public class UserDao extends JdbcDaoSupport {

    /*   JdbcTemplate jdbcTemplate;

       public JdbcTemplate getJdbcTemplate() {
           return jdbcTemplate;
       }

       public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
           this.jdbcTemplate = jdbcTemplate;
       }
   */
    public UserInfo findUser(String user_id) {
        String sql = "SELECT * FROM user WHERE user_id=?;";
        return super.getJdbcTemplate().queryForObject(sql, new Object[]{user_id}, new BeanPropertyRowMapper<UserInfo>());
    }
}
