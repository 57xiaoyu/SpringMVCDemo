package com.cch.hello.controller;

import com.cch.hello.bean.UserInfo;
import com.cch.hello.util.JsonUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.portlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


/**
 * Created by Fstar on 2016/12/29.
 */
@Controller
@RequestMapping(value = "/uploader", method = RequestMethod.GET)
public class UploadController {

    private static final String ACCESS_KEY = "SM5eEN1dWJpA1x-7VZwgB8JguPjl4xDKMSb2-ekq";
    private static final String SECRET_KEY = "xZu6Le2UFS1VvWEeirs6Q-3fOqCTaV2cCYfgNVc3";

    @ResponseBody
    @RequestMapping(value = "/upload_pic_url", method = RequestMethod.GET)
    public String uploadPicUrl(ModelMap model) {
        //文件保存的空间名和文件名
        String bucket = "ceshi";
        String key = "yourkey2222";

        //设置需要操作的账号的AK和SK
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        auth.uploadToken(bucket);

        Zone z = Zone.zone2();
        Configuration c = new Configuration(z);

        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, c);


        //要fetch的url
        String url = "http://e.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=863f8b02342ac65c67506e75cbc29e29/b999a9014c086e06a12d682903087bf40bd1cbcf.jpg";
//        String url = "http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4";

        try {
            //调用fetch方法抓取文件
            bucketManager.fetch(url, bucket, key);
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
            return "错误：" + r.toString();
        }

        return "upload_pic_url success";
    }

    @ResponseBody
    @RequestMapping(value = "/upload_movie_url", method = RequestMethod.GET)
    public String uploadMovieUrl(ModelMap model) {

        //文件保存的空间名和文件名
        String bucket = "ceshi";
        String key = "911Mothers_2010W-480p.mp4";

        //设置需要操作的账号的AK和SK
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        auth.uploadToken(bucket);

        Zone z = Zone.zone2();
        Configuration c = new Configuration(z);

        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, c);


        //要fetch的url
        String url = "http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4";


        try {
            //调用fetch方法抓取文件
            bucketManager.fetch(url, bucket, key);
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
            return "错误：" + r.toString();
        }

        return "upload_movie_url success";
    }


   /* @RequestMapping(value="/asynctask", method = RequestMethod.GET)
    public DeferredResult<ModelAndView> asyncTask(){
        DeferredResult<ModelAndView> deferredResult = new DeferredResult<ModelAndView>();
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());
        longTimeAsyncCallService.makeRemoteCallAndUnknownWhenFinish(new LongTermTaskCallback() {
            @Override
            public void callback(Object result) {
                System.out.println("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
                ModelAndView mav = new ModelAndView("remotecalltask");
                mav.addObject("result", result);
                deferredResult.setResult(mav);
            }
        });
    }*/

    @ResponseBody
    @RequestMapping(value="/longtimetask", method = RequestMethod.GET)
    public WebAsyncTask longTimeTask(){
        System.out.println("/longtimetask被调用 thread id is : " + Thread.currentThread().getId());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(3000); //假设是一些长时间任务

                System.out.println("执行成功 thread id is : " + Thread.currentThread().getId());
                return "longtimetask result  success";
            }
        };
        return new WebAsyncTask(callable);
    }
}
