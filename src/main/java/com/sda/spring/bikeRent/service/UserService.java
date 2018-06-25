package com.sda.spring.bikeRent.service;

import com.sda.spring.bikeRent.model.Role;
import com.sda.spring.bikeRent.model.User;
import com.sda.spring.bikeRent.repository.RoleRepository;
import com.sda.spring.bikeRent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public User addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(Long id) {
        userRepository.delete(getUserById(id));
    }

    public void editUser(Long id, User user) {
        User editingUser = getUserById(id);
        editingUser.setUserName(editingUser.getUserName());
        editingUser.setUserLastName(editingUser.getUserLastName());
        editingUser.setEmail(editingUser.getEmail());
        editingUser.setPassword(editingUser.getPassword());
        saveUser(editingUser);
    }
}
