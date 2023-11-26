package com.omidmohebbise.sp.modulith.inventory.model.repository;

import com.omidmohebbise.sp.modulith.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryJpaRepository extends JpaRepository<Inventory,Long> {
}
