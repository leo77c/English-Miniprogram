package com.miniprogram.www.service;

import com.miniprogram.www.entity.WebUser;

public interface WebUserService {

    boolean addWebUser(WebUser webUser);
    WebUser getWebUserByAccount(String account);
    WebUser webLogin(String account, String password);
}
