package com.login.loginUser.services.Impl;

import com.login.loginUser.domain.Permission;
import com.login.loginUser.exception.ResourceNotFoundException;
import com.login.loginUser.models.PermissionModel;
import com.login.loginUser.repositories.PermissionsRepository;
import com.login.loginUser.security.AuthUserInfo;
import com.login.loginUser.services.PermissionServices;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.login.loginUser.common.Constants.RECORD_DOES_NOT_EXIST_FOR_ID;
import static com.login.loginUser.specifications.PermissionsSpecification.withActive;
import static com.login.loginUser.specifications.PermissionsSpecification.withSearch;


@RequiredArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionServices {
    @NonNull PermissionsRepository permissionsRepository;
    @Override
    public Page<PermissionModel> getPermissions(AuthUserInfo user, Long branch, boolean active, String search, Pageable pageable) {
        Specification<Permission> permissionSpecification = Specification.where(withActive(active));
        if (!StringUtils.isEmpty(search)) {
            permissionSpecification = permissionSpecification.and(withSearch("title", search))
                    .or(withSearch("description", search)).or(withSearch("permissionCode", search));
        }
        return permissionsRepository.findAll(permissionSpecification, pageable)
                .map(PermissionModel::new);
    }

    @Override
    public PermissionModel createPermission(AuthUserInfo user, PermissionModel permissionModel) {
        permissionModel.setActive(true);
        permissionModel.setPermissionGroupId(1L);
        return new PermissionModel(permissionsRepository.save(permissionModel.disassemble()));
    }

    @Override
    public PermissionModel updatePermission(AuthUserInfo user, Long webId, PermissionModel permissionModel) {
        return permissionsRepository.findById(webId).map(permission -> {
            permission.setPermissionGroupId(permissionModel.getPermissionGroupId());
            permission.setDescription(permissionModel.getDescription());
            permission.setTitle(permissionModel.getTitle());
            permission.setUse(permissionModel.getUse());
            permission.setPermissionGroupId(1L);
            return new PermissionModel(permissionsRepository.save(permission));
        }).orElseThrow(() -> new ResourceNotFoundException(RECORD_DOES_NOT_EXIST_FOR_ID + user.getWebId()));
    }

    @Override
    public Boolean deletePermission(AuthUserInfo user, Long webId) {
        return permissionsRepository.findById(webId).map(permission -> {
            permissionsRepository.delete(permission);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException(RECORD_DOES_NOT_EXIST_FOR_ID + webId));
    }
}
