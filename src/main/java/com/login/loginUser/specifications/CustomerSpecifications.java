package com.login.loginUser.specifications;

import com.login.loginUser.domain.Customer;
import org.springframework.data.jpa.domain.Specification;

public interface CustomerSpecifications {
    static Specification<Customer> withStatusActive(boolean statusActive) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), statusActive);
    }
}
