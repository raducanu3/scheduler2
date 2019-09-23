package com.sda.scheduler2.repository;

import com.sda.scheduler2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
