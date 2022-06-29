package com.example.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT s FROM Users s WHERE s.email = ?1")
    Optional<Users> findUserBYEmail(String email);

    @Query("SELECT s FROM Users s WHERE s.name = ?1")
    List<Users> findUserBYname(String name);
}
