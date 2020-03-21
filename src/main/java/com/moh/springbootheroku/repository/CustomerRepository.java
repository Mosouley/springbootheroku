package com.moh.springbootheroku.repository;

import java.util.List;

import com.moh.springbootheroku.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

    List<Customer> findByLastName(String lastName);
}