package com.login.loginUser.controllers;


import com.login.loginUser.models.PermissionModel;
import com.login.loginUser.security.AuthUserInfo;
import com.login.loginUser.services.PermissionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.NonNull;

@RestController
@RequestMapping("/api/permission")
@RequiredArgsConstructor
public class PermissionController {
    @NonNull
    private final PermissionServices permissionServices;

    @GetMapping
    private ResponseEntity<Page<PermissionModel>> getPermissions(@AuthenticationPrincipal AuthUserInfo user,
                                                                 @RequestParam(required = false) String search,
                                                                 @RequestParam(required = false) Long branch,
                                                                 @RequestParam(required = false) boolean active,
                                                                 Pageable pageable) {
        return ResponseEntity.ok(permissionServices.getPermissions(user, branch, active, search, pageable));
    }

    @PostMapping
    private ResponseEntity<PermissionModel> createPermission(@AuthenticationPrincipal AuthUserInfo user,
                                                             @RequestBody PermissionModel permissionModel) {
        return ResponseEntity.ok(permissionServices.createPermission(user, permissionModel));
    }

    @PutMapping("{id}")
    private ResponseEntity<PermissionModel> updatePermission(@AuthenticationPrincipal AuthUserInfo user,
                                                             @PathVariable Long id,
                                                             @RequestBody PermissionModel permissionModel) {
        return ResponseEntity.ok(permissionServices.updatePermission(user, id, permissionModel));
    }

    @DeleteMapping("{id}")
    private Boolean getPermissions(@AuthenticationPrincipal AuthUserInfo user,
                                   @PathVariable Long id) {
        return permissionServices.deletePermission(user, id);
    }

}
