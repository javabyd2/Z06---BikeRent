package com.sda.spring.bikeRent.repository;

import com.sda.spring.bikeRent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByuserName(String userName);

    public User findByuserLastName(String userLastName);

    public User findByEmail(String email);
}
