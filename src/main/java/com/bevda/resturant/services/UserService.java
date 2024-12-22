package com.bevda.resturant.services;

import com.bevda.resturant.entities.User;

public interface UserService {
    User savedUser(User user);
    User updatedUser(User user, String userId);

    public void testUserRole();
}
