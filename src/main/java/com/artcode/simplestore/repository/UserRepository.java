package com.artcode.simplestore.repository;

import com.artcode.simplestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {

    public String findByEmail(String email);
}
