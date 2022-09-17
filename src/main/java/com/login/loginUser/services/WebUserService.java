package com.login.loginUser.services;

import com.login.loginUser.models.WebUserModel;
import com.login.loginUser.security.AuthUserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WebUserService {
    WebUserModel signup(WebUserModel webUser);

    Page<WebUserModel> getAllUsers(AuthUserInfo userInfo, Boolean active, Pageable pageable);
}
