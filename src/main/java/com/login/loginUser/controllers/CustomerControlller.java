package com.login.loginUser.controllers;

import com.login.loginUser.models.CustomerModel;
import com.login.loginUser.security.AuthUserInfo;
import com.login.loginUser.services.CustomerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class CustomerControlller {
    @NonNull
    private final CustomerService customerService;

    @GetMapping("/Customerlist")
    public ResponseEntity<Page<CustomerModel>> get(@AuthenticationPrincipal AuthUserInfo user,
                                                  Pageable pageable) {
        return ResponseEntity.ok(customerService.getAllUsers(user, true, pageable));
    }
}
