package com.codewith.firstApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codewith.firstApp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}