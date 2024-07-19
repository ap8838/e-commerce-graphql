package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.domain.User;
import com.atomtechnologies.ecommerce.demo.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;

@DgsComponent
public class UserMutation {

    private final UserService userService;

    public UserMutation(UserService userService) {
        this.userService = userService;
    }

    @DgsMutation
    public User addUser(String name, String email, String profile) {
        return userService.addUser(name, email, profile);
    }
}
