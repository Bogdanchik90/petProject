package com.example.crud.service;

import com.example.crud.dto.UserDto;
import com.example.crud.model.User;
import com.example.crud.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceMethods {

    @Autowired
    private final Repository repository;

    public ServiceMethods(Repository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserDto addPhone(User user, String phone) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setDate(user.getDate());
        dto.setPhone(phone);

        repository.editUser(dto, user.getId());

        return dto;
    }
}
