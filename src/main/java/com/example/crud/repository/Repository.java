package com.example.crud.repository;

import com.example.crud.dto.UserDto;
import com.example.crud.model.User;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository {

    List<User> getAllUsers();

    Integer addUser(User user);

    void editUser(User userDetails, int id);

    void editUser(UserDto userDetailsDto, int id);

    void deleteUserById(int id);

    User getUserById(int id);

    boolean isTableUsersEmpty();

    Optional<User> getUserByName(String username);
}
