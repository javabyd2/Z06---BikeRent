package com.sda.spring.bikeRent.repository;

import com.sda.spring.bikeRent.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    public User findByUsername(String name);

    public User findByLastname(String lastName);

    public User findByEmail(String email);

}
