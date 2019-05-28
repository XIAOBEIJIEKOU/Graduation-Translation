package com.graduation.demo.controller;

import com.graduation.demo.dao.Userdao;
import com.graduation.demo.model.User;
import com.graduation.demo.service.TranslateService;
import com.graduation.demo.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TranslateController {

    private TranslateService translateService;

    @Autowired
    private Userdao userdao;

    @Autowired
    private BaseResponse baseResponse;

    @RequestMapping(value = "/translate", method = {RequestMethod.GET}, consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    private Object translate(@RequestParam(name = "query") String query , @RequestParam(name = "to") String to){
        if ("".equals(query)){
            baseResponse.setContent("");
            return baseResponse;
        }
        baseResponse.setStatus("success");
        baseResponse.setContent(translateService.translate(query , to));
        return baseResponse;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET}, consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    private Object login(@RequestParam(name = "email") String email , @RequestParam(name = "password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User user1 = userdao.login(user);
        if (null == user1){//未注册或密码错误
            baseResponse.setContent("wrong");
            return baseResponse;
        } else {//正确
            baseResponse.setContent("login");
            return baseResponse;
        }
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET}, consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    private Object register(@RequestParam(name = "email") String email , @RequestParam(name = "password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        if (userdao.register(user) == 1){
            baseResponse.setContent("register");
            return baseResponse;
        } else {
            return null;
        }
    }
}
