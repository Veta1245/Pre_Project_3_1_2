package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(Long id);


    List<User> listUsers();

    void updateUser(Long id, User user);

    User showUser(Long id);

    User findByUsername(String username);


}
