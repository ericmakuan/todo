package com.example.demo.userList;

import com.example.demo.userList.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<UserList, Long> {
    @Query("SELECT s FROM UserList s WHERE s.email = ?1")
    Optional<UserList> findUserListBYEmail(String email);
}
