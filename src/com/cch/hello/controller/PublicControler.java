package com.cch.hello.controller;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fstar on 2016/12/29.
 */
@Controller
@RequestMapping(value = "/public", method = RequestMethod.GET)
public class PublicControler {
    @ResponseBody
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String printHello(ModelMap model) {

        return "config:4123qwdasdq2353426636twertery78uyjfsasasd4t34t5467";
    }
}
