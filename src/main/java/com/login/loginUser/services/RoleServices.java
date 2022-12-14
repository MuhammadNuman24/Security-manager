package com.login.loginUser.services;


import com.login.loginUser.models.RoleModel;
import com.login.loginUser.models.RolePermissionModel;
import com.login.loginUser.security.AuthUserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: itinsync-waqas
 * Date: 4/27/21
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleServices {
    Page<RoleModel> getRoles(AuthUserInfo user, Long branch, boolean active, String search, Pageable pageable);

    List<RolePermissionModel> getRolesAndPermission(AuthUserInfo user, Long webId);

    RolePermissionModel addOrDeleteRolePermissions(AuthUserInfo user, Long webId, RolePermissionModel rolePermissionModel);

    RoleModel createRole(AuthUserInfo user, RoleModel roleModel);

    RoleModel updateRole(AuthUserInfo user, Long userId, RoleModel roleModel);

    Boolean deleteRole(AuthUserInfo user, Long userId);
}
