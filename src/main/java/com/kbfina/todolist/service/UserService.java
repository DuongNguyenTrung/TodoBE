package com.kbfina.todolist.service;

import java.util.ArrayList;

import com.kbfina.todolist.domain.User;


public interface UserService {
    public User saveUser(User user);
    public User getUser(int id);
    public ArrayList<User> getAllUser();
    public void delete(int id);
    public boolean login(User user);
}