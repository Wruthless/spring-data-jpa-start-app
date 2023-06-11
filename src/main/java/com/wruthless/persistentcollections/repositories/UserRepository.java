package com.wruthless.persistentcollections.repositories;

import com.wruthless.persistentcollections.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
