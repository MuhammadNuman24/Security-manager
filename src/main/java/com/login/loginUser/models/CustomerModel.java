package com.login.loginUser.models;

import com.login.loginUser.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private Long webId;
    private Long clientId;
    private String description;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Long branchId;
    private Long customerId;
    private Integer status;
    private List<String> featureGated = new ArrayList<>();

    public CustomerModel(Customer customer) {
        this.webId = customer.getWebId();
        this.description = customer.getFirstName() + " " + customer.getLastName();
        this.status = customer.getStatus();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
    }

}
