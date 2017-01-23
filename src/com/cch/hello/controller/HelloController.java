package com.cch.hello.controller;

import com.cch.hello.bean.UserInfo;
import com.cch.hello.util.JsonUtil;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Fstar on 2016/12/29.
 */
@Controller
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class HelloController {

    private static final String ACCESS_KEY = "SM5eEN1dWJpA1x-7VZwgB8JguPjl4xDKMSb2-ekq";
    private static final String SECRET_KEY = "xZu6Le2UFS1VvWEeirs6Q-3fOqCTaV2cCYfgNVc3";

    @ResponseBody
    @RequestMapping(value = "/get_token", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String token = auth.uploadToken("ceshi");

       // model.addAttribute("msg", "Spring MVC Hello World");
       // model.addAttribute("name", "yuntao");
        return token;
    }

    @ResponseBody
    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        //String hql = "select c from Clothing c ";
        List<UserInfo> list=new ArrayList<>();
        list.add(new UserInfo("id_1","name_1",""));
        list.add(new UserInfo("id_2","name_2",""));
        list.add(new UserInfo("id_3","name_3",""));
        list.add(new UserInfo("id_4","name_4",""));
        list.add(new UserInfo("id_5","name_5",""));

        return JsonUtil.toJson(list);
    }
}
