package com.kbfina.todolist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idtodo;
    @Column(nullable = false)
    public int idAccount;
    public Boolean status;
    @Column(nullable = false)
    public String todoname;
}
