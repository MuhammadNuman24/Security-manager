package com.login.loginUser.repositories;

import com.login.loginUser.domain.Customer;
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
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    Optional<Customer> findByEmailIgnoreCaseAndStatus(String userName, Integer status);

    Optional<Customer> findByWebIdAndActiveAndStatus(Long webId, boolean active, Integer status);

    int countByEmailIgnoreCaseAndStatus(String userName, Integer status);;

//    @Query("select i from File i where i.entityWebId=:userId")
//    ImageModel getFileByUserId(Long userId);
}
