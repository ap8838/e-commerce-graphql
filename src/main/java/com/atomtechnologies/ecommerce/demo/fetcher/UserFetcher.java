package com.atomtechnologies.ecommerce.demo.fetcher;

import com.atomtechnologies.ecommerce.demo.domain.User;
import com.atomtechnologies.ecommerce.demo.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class UserFetcher {
    private final UserService userService;

    public UserFetcher(UserService userService) {
        this.userService = userService;
    }

    @DgsQuery
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @DgsQuery
    public User getUserById(@InputArgument Long userId) {
        return userService.getUserById(userId);
    }
}