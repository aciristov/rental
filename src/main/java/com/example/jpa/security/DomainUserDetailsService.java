package com.example.jpa.security;

import com.example.jpa.model.Customer;
import com.example.jpa.repository.CustomerRepository;
import com.example.jpa.repository.CustomerRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final CustomerRepository customerRepository;
    private final CustomerRoleRepository customerRoleRepository;

    public DomainUserDetailsService(CustomerRepository customerRepository,
                                    CustomerRoleRepository customerRoleRepository) {
        this.customerRepository= customerRepository;
        this.customerRoleRepository = customerRoleRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String name) {
        log.debug("Authenticating {}", name);

        Customer customer = customerRepository.findOneWithRolesByName(name).orElseGet(null);

        return createSpringSecurityUser(name, customer);
    }

//        return customerRepository.findOneByName(name)
//            .map(customer -> createSpringSecurityUser(name, customer))
//            .orElseThrow(() -> new UsernameNotFoundException("User " + name + " was not found in the database"));
//    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String name, Customer customer) {
//        List<GrantedAuthority> grantedAuthorities = customer.getRoles().stream()
//            .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//            .collect(Collectors.toList());
        List<GrantedAuthority> grantedAuthorities = customerRoleRepository.findAllByCustomerId(customer.getCustomerid())
                .stream()
                .map(it -> new SimpleGrantedAuthority((it.getName())))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(customer.getName(),
            customer.getPassword(),
            grantedAuthorities);
    }
}
