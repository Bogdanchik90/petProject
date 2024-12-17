package com.example.crud.orchestrator;

import com.example.crud.model.User;
import com.example.crud.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Orchestrator {
    private final Repository repository;
    @Autowired
    public Orchestrator(Repository repository){
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.getAllUsers();
    }
}
