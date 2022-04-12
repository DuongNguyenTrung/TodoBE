package com.kbfina.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kbfina.todolist.domain.Category;
public interface CategoryRepository extends JpaRepository<Category,Integer>{
    
}
