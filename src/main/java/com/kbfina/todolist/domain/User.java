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
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public int idAccount;
    @Column(unique = true,nullable = false)
    public String username;
    @Column(nullable = false)
    public String password;
    
}
