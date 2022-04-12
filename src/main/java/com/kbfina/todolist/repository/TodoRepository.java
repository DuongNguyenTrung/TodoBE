package com.kbfina.todolist.repository;

import java.util.List;

import com.kbfina.todolist.domain.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Todo, Integer> {
  List<Todo> findByIdAccount(int idAccount); 
}
