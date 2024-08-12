package com.workintech.ecommerce_backend.repo;

import com.workintech.ecommerce_backend.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
