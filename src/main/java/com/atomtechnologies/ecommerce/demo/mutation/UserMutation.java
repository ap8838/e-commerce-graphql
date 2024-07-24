package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.codegen.types.RegisterUserInput;
import com.atomtechnologies.ecommerce.demo.domain.User;
import com.atomtechnologies.ecommerce.demo.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class UserMutation {
    private final UserService userService;

    public UserMutation(UserService userService) {
        this.userService = userService;
    }

    @DgsMutation
    public User registerUser(@InputArgument RegisterUserInput input) {
        return userService.addUser(input.getName(), input.getEmail(), input.getProfile());
    }
}
