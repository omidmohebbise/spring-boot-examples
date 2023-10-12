package com.omidmohebbise.sp.modulith.order.model.repository;

import com.omidmohebbise.sp.modulith.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order,Long> {
}
