package com.login.loginUser.repositories;

import com.login.loginUser.domain.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Muhammad NUman
 * Date: 16/09/22
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public interface WebUserRepository extends JpaRepository<WebUser, Long>, JpaSpecificationExecutor<WebUser> {
    Optional<WebUser> findByEmailIgnoreCaseAndStatus(String userName, Integer status);

    Optional<WebUser> findByWebIdAndActiveAndStatus(Long webId, boolean active, Integer status);

    int countByEmailIgnoreCaseAndStatus(String userName, Integer status);;

//    @Query("select i from File i where i.entityWebId=:userId")
//    ImageModel getFileByUserId(Long userId);
}
