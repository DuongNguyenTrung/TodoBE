package com.kbfina.todolist.controller;

import java.util.List;

import com.kbfina.todolist.domain.Todo;
import com.kbfina.todolist.model.DateBetween;
import com.kbfina.todolist.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/todo/{id}")
    public ResponseEntity<List<Todo>> list(@PathVariable(value = "id") int id) {
        try {
            List<Todo> list = todoRepository.findByIdAccount(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(value = "/todo/date/{id}")
    public ResponseEntity<List<Todo>> getByDate(@PathVariable(value = "id") int id,@RequestBody DateBetween dateBetween) {
        try {
            
            List<Todo> list = todoRepository.findByIdAccountAndDeadlineBetween(id,dateBetween.start,dateBetween.end);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> add(@RequestBody Todo todo) {
        try {
           Todo td = todoRepository.save(todo);
            return new ResponseEntity<Todo>(td, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> remove(@PathVariable Integer id) {
        try {
            todoRepository.delete(todoRepository.getById(id));
            return new ResponseEntity<String>("delete todolist successful !", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("delete todolist fail !", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<String> update(@RequestBody Todo todo,@PathVariable("id") int id) {
        try {
            Todo td = todoRepository.findById(id).get();
            if(todo.status!=null)td.status=todo.status;
            if(todo.todoname!="")td.todoname=todo.todoname;
            if(todo.categoryID!=null)td.categoryID=todo.categoryID;
            if(todo.deadline!=null)td.deadline=todo.deadline;


            todoRepository.save(td); 
            return new ResponseEntity<String>("update todolist successful !", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("update todolist fail !", HttpStatus.NOT_FOUND);
        }
    }
}
