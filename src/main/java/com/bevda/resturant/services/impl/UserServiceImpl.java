package com.bevda.resturant.services.impl;

import com.bevda.resturant.entities.Resturant;
import com.bevda.resturant.entities.RoleEntity;
import com.bevda.resturant.entities.User;
import com.bevda.resturant.repositories.UserRepositories;
import com.bevda.resturant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    private UserRepositories userRepositories;

    public UserServiceImpl(UserRepositories userRepositories){
        this.userRepositories = userRepositories;
    }

    @Override
//    @Transactional
    public User savedUser(User user) {
        user.setId(UUID.randomUUID().toString());
        User savedEntity = userRepositories.save(user);
        return savedEntity;
    }

    @Override
    @Transactional
    public User updatedUser(User user, String userId) {
        // getUser
        // Usme ek naya resturant add karenge
        User user1 = userRepositories.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        user1.setName(user.getName());
        // .. all fields
        User save = userRepositories.save(user1);
        System.out.println("user: "+save.getName()+" is updated");
        return save;
    }

    @Override
    public void testUserRole() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("vicky");
        user.setEmail("vinay171@gmail.com");
        user.setAvailable(true);
        user.setAddress("Testing address for many to many");
        user.setPassword("abc");

        //
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("ROLE_ADMIN");

        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setName("ROLE_GUEST");

        //link
        //user ki taraf se
        user.getRoleEntities().add(roleEntity1);
        user.getRoleEntities().add(roleEntity);

        //entities
        roleEntity.getUsers().add(user);
        roleEntity1.getUsers().add(user);

        userRepositories.save(user);
        System.out.println("user saved :");

    }
}
