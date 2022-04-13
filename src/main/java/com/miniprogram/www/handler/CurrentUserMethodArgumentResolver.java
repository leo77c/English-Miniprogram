package com.miniprogram.www.handler;

import com.miniprogram.www.annotation.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;


/**
 * 解析token拦截器中添加的用户id信息，使Controller可以通过@CurrentUser来得到当前请求的userid
 */
public class CurrentUserMethodArgumentResolver  implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(Integer.class)
                && methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 获取拦截器中获取的当前用户信息
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        Integer currentUserId = (Integer) request.getAttribute("userid");
        // 如果当前用户信息为null  则抛出异常
        if (currentUserId != null){
            return currentUserId;
        } throw new MissingServletRequestPartException("userid");
    }
}