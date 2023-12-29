package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findById(Math.toIntExact(id)).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setId(Math.toIntExact(id));
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User showUser(Long id) {
        return userRepository.findById(Math.toIntExact(id)).orElseThrow(EntityNotFoundException::new);
    }
}

