package com.bevda.resturant.service;

import com.bevda.resturant.entities.Resturant;
import com.bevda.resturant.entities.Role;
import com.bevda.resturant.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserService {

    @Autowired
    private com.bevda.resturant.services.UserService userService;

    @Test
    public void testSavedUser(){
        System.out.println("saved user");
        // user
        User user = new User();
        user.setName("Vinay Dahariya");
        user.setEmail("targetit99@gmail.com");
        user.setAvailable(true);
        user.setAddress("Test address, Allahabad");
        user.setPassword("abc");
        user.setRole(Role.ADMIN);

        // resturant

        Resturant resturant = new Resturant();
        resturant.setId(UUID.randomUUID().toString());
        resturant.setName("KFC");
        resturant.setAddress("Allahabad");
        resturant.setOpen(true);

        Resturant resturant1 = new Resturant();
        resturant1.setId(UUID.randomUUID().toString());
        resturant1.setName("Hardiram");
        resturant1.setAddress("Allahabad");
        resturant1.setOpen(true);

        resturant1.setUser(user);
        resturant.setUser(user);

//        user.getResturants().add(resturant);
//        user.getResturants().add(resturant1);

        User user1 = userService.savedUser(user);

        System.out.println(user1.getName());


    }

    @Test
    public void testUpdateUser(){

        userService.testUserRole();
//        userService.updatedUser();
    }


}
