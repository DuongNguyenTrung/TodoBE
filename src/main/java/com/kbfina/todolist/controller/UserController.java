package com.kbfina.todolist.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.kbfina.todolist.domain.User;
import com.kbfina.todolist.repository.UserRepository;
import com.kbfina.todolist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController

@RequestMapping(value="/api")
public class UserController {
    @Autowired
    private UserService userService; 
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/user")
    public List<User> getAllUser(){

        return userService.getAllUser();
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") int id){
        User user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public String RemoveUser(@PathVariable(value = "id") int id){
        
        try {
            userService.delete(id);
            return "delete successfully !";
        } catch (Exception e) {
            return "something wrong";
        }
    }

    @PostMapping(value="/user")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "user add successfully !";
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user/signin")
    public ResponseEntity<User> authenticateUser(@RequestBody User user){
        if(userRepository.login(user.username, user.password)!=null){
            User res= userRepository.findByUsername(user.username);
            res.password=null;

            return new ResponseEntity<User>(res, HttpStatus.OK);
        } 
        return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
        
    }

    
    
}
