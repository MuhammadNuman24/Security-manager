package com.login.loginUser.services.Impl;

import com.login.loginUser.domain.Customer;
import com.login.loginUser.models.CustomerModel;
import com.login.loginUser.repositories.CustomerRepository;
import com.login.loginUser.security.AuthUserInfo;
import com.login.loginUser.services.CustomerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static com.login.loginUser.specifications.CustomerSpecifications.withStatusActive;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @NonNull
    private final CustomerRepository customerRepository;

    @Override
    public Page<CustomerModel> getAllUsers(AuthUserInfo userInfo, Boolean active, Pageable pageable) {
        Specification<Customer> customerSpecification= Specification.where(withStatusActive(true));
        return customerRepository.findAll(customerSpecification, pageable).map(CustomerModel::new);
    }


}
