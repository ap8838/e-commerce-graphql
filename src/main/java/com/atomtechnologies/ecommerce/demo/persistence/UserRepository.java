package com.atomtechnologies.ecommerce.demo.persistence;

import com.atomtechnologies.ecommerce.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}