package com.cch.hello.bean;

/**
 * Created by Fstar on 2016/12/29.
 */
public class UserInfo {
    public String user_id;
    public String user_name;
    public String user_avatar;
    public String user_pwd;

    public UserInfo(String user_id, String user_name, String user_avatar, String user_pwd) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_avatar = user_avatar;
        this.user_pwd = user_pwd;
    }

    public UserInfo() {
        super();
    }
}
