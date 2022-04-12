package com.kbfina.todolist.repository;

import java.util.List;

import com.kbfina.todolist.domain.Todo;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Todo, Integer> {
  List<Todo> findByIdAccount(int idAccount);
  List<Todo>  findByIdAccountAndCategoryID(int idAccount,int categoryID);
  List<Todo>  findByIdAccountAndDeadlineBetween(int idAccount,Date start,Date end);
}
