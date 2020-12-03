package com.davCode.ecommerce.dao;

import com.davCode.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepsitory extends JpaRepository<Customer, Long> {
}
