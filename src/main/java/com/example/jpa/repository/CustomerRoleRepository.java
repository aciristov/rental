package com.example.jpa.repository;

import com.example.jpa.model.CustomerRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRoleRepository extends JpaRepository<CustomerRole, Long> {
    List<CustomerRole> findAllByCustomerId(Long customerId);
}