package com.login.loginUser.models;

import com.login.loginUser.domain.Permission;
import com.login.loginUser.domain.Role;
import com.login.loginUser.domain.RolePermission;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolePermissionModel {
    private Long webId;

    private Long clientId;
    private Long role;
    private String roleTitle;
    private String permissionTitle;
    private String permissionCode;
    private String permissionUse;
    private String roleUse;
    private String externalKey;
    private Boolean notRolePermission;
    private String addDelete;
    private Long permission;
    public RolePermissionModel(RolePermission rolePermission) {
        this.webId = rolePermission.getWebId();
        this.role = rolePermission.getRole().getWebId();
        this.permission = rolePermission.getPermission().getWebId();
    }

    public RolePermission disassemble() {
        var rolePermission = new RolePermission();
        var role = new Role();
        var permission = new Permission();
        rolePermission.setWebId(this.webId);
        rolePermission.setPermission(permission);
        rolePermission.setRole(role);
        return rolePermission;
    }

    public RolePermissionModel assemble(RolePermission rolePermission) {
        return new RolePermissionModel(rolePermission);
    }
}
