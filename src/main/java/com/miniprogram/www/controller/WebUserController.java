package com.miniprogram.www.controller;

import com.miniprogram.www.entity.WebUser;
import com.miniprogram.www.service.WebUserService;
import com.miniprogram.www.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webuser")
public class WebUserController {

    @Autowired
    private WebUserService webUserService;

    /**
     * @description 网页端教师用户注册功能函数，从注册页面注册的用户默认为教师，管理员用户只能通过已有管理员增添
     * @param account
     * @param password
     * @param name
     * @return
     */
    @RequestMapping("/register")
    public Map<String, Object> registerForTeacher(@RequestParam(value = "username", required = true) String account,
                                                  @RequestParam(value = "password", required = true) String password,
                                                  @RequestParam(value = "name", required = true) String name) {
        Map<String, Object> response = new HashMap<String, Object>();
        WebUser webUser = new WebUser();
        webUser.setAccount(account);
        webUser.setPassword(password);
        webUser.setName(name);
        webUser.setType(0);

        if (webUserService.addWebUser(webUser)) {
            response.put("success", true);
        }else  response.put("success", false);
        return response;
    }

    /**
     * @description 网页端用户登录功能函数，根据账号密码登录，返回token、userinfo等信息
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Map<String, Object> loginForWeb(@RequestParam(value = "username", required = true) String account,
                                                  @RequestParam(value = "password", required = true) String password) {
        Map<String, Object> response = new HashMap<String, Object>();
        WebUser webUser = webUserService.webLogin(account, password);

        System.out.println("web用户登录成功！id为" + webUser.getId());

        response.put("token", JWTUtils.createWebToken(webUser));
        response.put("success",true);
        webUser.setId(0);
        webUser.setPassword("");
        response.put("userInfo",webUser);

        return response;
    }
}
