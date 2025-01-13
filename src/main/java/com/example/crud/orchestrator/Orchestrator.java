package com.example.crud.orchestrator;

import com.example.crud.model.User;
import com.example.crud.repository.Repository;
import com.example.crud.service.ServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Orchestrator {
    private final Repository repository;
    private final ServiceMethods service;
    @Autowired
    public Orchestrator(Repository repository, ServiceMethods service){
        this.repository = repository;
        this.service = service;
    }

    public List<User> getAll() {
        return repository.getAllUsers();
    }

    @Transactional
    public int addUser(User user) {
        return repository.addUser(user);
    }

    @Transactional
    public void update(User user, int id) {
        repository.editUser(user, id);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteUserById(id);
    }

    public User getUserById(int id) {
        return repository.getUserById(id);
    }
}
