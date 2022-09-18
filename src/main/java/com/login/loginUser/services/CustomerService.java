package com.login.loginUser.services;

import com.login.loginUser.models.CustomerModel;
import com.login.loginUser.security.AuthUserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<CustomerModel> getAllUsers(AuthUserInfo userInfo, Boolean active, Pageable pageable);
}
