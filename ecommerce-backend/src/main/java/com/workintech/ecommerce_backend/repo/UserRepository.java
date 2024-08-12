package com.workintech.ecommerce_backend.repo;

import com.workintech.ecommerce_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.store = null WHERE u.store.id = :storeId")
    void updateStoreIdToNull(long storeId);
}
