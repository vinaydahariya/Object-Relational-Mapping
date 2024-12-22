package com.bevda.resturant.repositories;

import com.bevda.resturant.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, String> {

}
