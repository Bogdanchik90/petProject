package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.orchestrator.Orchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getAllData() {
        List<User> userList = orchestrator.getAll();
        for (User user : userList) {
            System.out.println(user);
        }
        return "helow";
    }
}
