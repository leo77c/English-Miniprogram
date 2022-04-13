package com.miniprogram.www.controller;

import com.miniprogram.www.annotation.CurrentUser;
import com.miniprogram.www.entity.Student;
import com.miniprogram.www.service.UserService;
import com.miniprogram.www.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @description 实现小程序的登录功能，调用userService
     * @param code 小程序传入的登录code
     * @return
     */
    @RequestMapping("/wxLogin")
    public Map<String, Object> wxLogin(@RequestParam(value = "code", required = true) String code) {
        System.out.println(code);
        Map<String, Object> response = new HashMap<String, Object>();
        Student student = userService.wxLogin(code);

        if (student != null) {
            response.put("success", true);
            response.put("token", JWTUtils.createWxToken(student));

            //隐藏id和openid的信息
            student.setId(0);
            student.setOpenid("");
            response.put("userInfo", student);
        }else {
            response.put("success", false);
        }
        return response;
    }

    /**
     * @description 小程序端更新用户信息
     * @param userInfo
     * @param currentUserId
     * @return
     */
    @RequestMapping(value = "/wxUpdateInfo", method = RequestMethod.POST)
    public Map<String, Object> wxUpdateInfo( @RequestBody Student userInfo, @CurrentUser Integer currentUserId ) {
        Map<String, Object> response = new HashMap<String, Object>();
        userInfo.setId(currentUserId);
        if (userService.updateStudentInfo(userInfo)) {
            response.put("success", true);
        }else  response.put("success", false);

        return response;
    }
}
