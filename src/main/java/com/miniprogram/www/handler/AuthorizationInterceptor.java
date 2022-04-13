package com.miniprogram.www.handler;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.miniprogram.www.entity.Student;
import com.miniprogram.www.service.UserService;
import com.miniprogram.www.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    /**
     * @description 拦截请求，判断是否带有token，若token验证成功则为request添加userid
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            throw new RuntimeException("token不能为空!");
        }

        try {
            Map<String, Claim> claims = JWTUtils.verifyToken(token);
            int userid = claims.get("id").asInt();
            Student student = userService.getStudentById(userid);

            if (claims.get("openid").asString().equals(student.getOpenid())) {
                request.setAttribute("userid", student.getId());
            }else throw new RuntimeException("用户id与openid不匹配！");

        } catch (SignatureVerificationException e) {
            throw new RuntimeException("无效签名！");
        } catch (TokenExpiredException e) {
            throw new RuntimeException("token过期！");
        } catch (AlgorithmMismatchException e) {
            throw new RuntimeException("token算法不一致！");
        }

        return true;
    }

}
