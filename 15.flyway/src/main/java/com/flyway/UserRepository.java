package com.flyway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flyway.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
