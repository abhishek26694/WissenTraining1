package com.insurance.login.Repository;

import com.insurance.login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer > {

    public User findByUsername(String username);
}