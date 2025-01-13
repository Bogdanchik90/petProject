package com.example.crud.repository;

import com.example.crud.dto.UserDto;
import com.example.crud.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean isTableUsersEmpty() {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM User ");
        Long count = (Long) query.getSingleResult();
        return count == 0;
    }


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Integer addUser(User user) {
        User savedUser = entityManager.merge(user);
        return savedUser.getId();
    }

    @Override
    public void editUser(User userDetails, int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setDate(userDetails.getDate());
            entityManager.merge(user);
        } else {
            throw new RuntimeException("Пользователь с таким id не найден");
        }
    }

    @Override
    public void editUser(UserDto userDetailsDto, int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(userDetailsDto.getName());
            user.setDate(userDetailsDto.getDate());
            user.setPhone(userDetailsDto.getPhone());
            entityManager.merge(user);
        } else {
            throw new RuntimeException("Пользователь с таким id не найден");
        }
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public Optional<User> getUserByName(String username) {
        String query = "SELECT u FROM User u WHERE u.name = :username";
        try {
            User user = entityManager.createQuery(query, User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return Optional.of(user);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

}
