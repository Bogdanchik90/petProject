package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.orchestrator.Orchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1")
public class Controller {
    private final Orchestrator orchestrator;

    @Autowired
    public Controller(Orchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }


    @GetMapping("/getAllData")
    public ResponseEntity<List<User>> getAllData() {
        List<User> userList = orchestrator.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        orchestrator.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {

        orchestrator.update(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
        orchestrator.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
