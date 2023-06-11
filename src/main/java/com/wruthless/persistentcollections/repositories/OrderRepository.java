package com.wruthless.persistentcollections.repositories;

import com.wruthless.persistentcollections.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
