package com.kbfina.todolist.repository;

import com.kbfina.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT e FROM User e WHERE e.username = ?1 AND e.password = ?2")
    User login(String username,String password);

    User findByUsername(String username);
}
