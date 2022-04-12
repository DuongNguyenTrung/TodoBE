package com.kbfina.todolist.service;

import java.util.ArrayList;

import com.kbfina.todolist.domain.User;
import com.kbfina.todolist.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public ArrayList<User> getAllUser() {
        return (ArrayList<User>) userRepository.findAll();
    }
    @Override
    public void delete(int id) {
        userRepository.delete(userRepository.getById(id));
    }
    @Override
    public boolean login(User user) {
        System.out.println(user.username);
        if(userRepository.login(user.username, user.password) != null) return true;
        return false;
    }

    // public boolean login2(UserModel user){
    //     User User = userRepository.findByUsername(user.getUsername());
    //     return true;
    // }
}
