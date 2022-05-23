package com.example.elk.controller;

import com.example.elk.model.Role;
import com.example.elk.model.RoleEnum;
import com.example.elk.model.User;
import com.example.elk.service.UserService;
import com.example.elk.swagger.user.api.UserApi;
import com.example.elk.swagger.user.model.*;
import com.example.elk.util.Util;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private UserService userService;

    @Override
    public ResponseEntity<UserAndRolesResponse> addRoleToUSer(UserAndRoleRequest userAndRoleRequest) {
        log.info("Request add a role to a user: {}", userAndRoleRequest );
        User user = User.builder()
                        .username(userAndRoleRequest.getUsername())
                        .build();
        Role role = Role.builder()
                        .name(RoleEnum.fromValue(userAndRoleRequest.getRole()))
                        .build();
        User updatedUser = userService.addRoleToUser(user, role);
        return new ResponseEntity<>(Util.modelToDto(updatedUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
        log.info("Request add a new user: {}", userRequest);
        User user = userService.saveUser(Util.dtoToModel(userRequest));
        return new ResponseEntity<>(Util.modelToDtoBasic(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsersAndRolesResponse> getUsers() {
        List<User> users = userService.getUsers();

        UsersAndRolesResponse response = new UsersAndRolesResponse();
        List<UserAndRolesResponse> userAndRoles = users.stream()
                                                       .map(Util::modelToDto)
                                                       .collect(Collectors.toList());
        response.setUsers(userAndRoles);
        response.setSize(userAndRoles.size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
